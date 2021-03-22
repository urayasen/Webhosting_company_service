package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<String> rows = new ArrayList<>();
        rows.add("C 1.1 8.15.1 P 15.10.2012 83");
        rows.add("C 1 10.1 P 01.12.2012 65");
        rows.add("C 1.1 5.5.1 P 01.11.2012 117");
        rows.add("D 1.1 8 P 01.01.2012-01.12.2012");
        rows.add("C 3 10.2 N 02.10.2012 100");
        rows.add("D 1 * P 08.10.2012-20.11.2012");
        rows.add("D 3 10 P 01.12.2012");

        //тут ми  створюємо колекцію об'єктів
        List<Service> serviceList = new ArrayList<>();
        serviceList.add(new Service("C", "1", "1", "8", "15",
                "1", "P", "15.10.2012", "83"));
        serviceList.add(new Service("C", "1", "null", "10",  "1",
                "null", "P", "01.12.2012", "65"));
        serviceList.add(new Service("C", "1", "1 ", "5", "5",
                "1", "P", "01.11.2012", "117"));
        serviceList.add(new Service("D", "1","1","8", "null",
                "null", "P", "01.01.2012-01.12.2012", "null"));
        serviceList.add(new Service("C", "3", "null", "10", "2",
                "null", "N","02.10.2012", "100"));
        serviceList.add(new Service("D", "1","null", "null", "null",
                "null", "P","08.10.2012-20.11.2012","null"));
        serviceList.add(new Service("D", "3", "null", "10", "null",
                "null","P"," 01.12.2012-01.12.2012", "null"));

        service(serviceList);


    }

    static void service(List<Service> serviceList){

        Collections.reverse(serviceList);

        List<Service> serviceOnlyDs = serviceList
                .stream()
                .filter(service ->
                        service.getService_type() == "D"
                )
                .collect(Collectors.toList());



        Service serviceOne = serviceOnlyDs.get(2);//тут ми вставляємо числа від 0 до 2 в залежності від відповіді типу D
        System.out.println(serviceOne);


        List<Service> serviceListAfterFilter = serviceList
                .stream()
                .filter(service -> service.getService_type()!= serviceOne.getService_type())//фільтрування по типу служби
                .filter(service -> service.getService_id()==serviceOne.getService_id())//фільтрування по id служби
                .filter(service ->{//фільтрування по типу запитання
                    if(serviceOne.getQuestion_type_id()!="null") {
                        return service.getQuestion_type_id()==serviceOne.getQuestion_type_id();
                    }else{

                        return  service.getP_N()==serviceOne.getP_N();
                    }

                })
                .filter(service -> {//фільтрування по даті
                    Date dateOfServiveOneAfter=null, dateOfService=null, dateOfServiveOneBefore=null;

                    String dateService = service.getDate();
                    String[] serviceOneDate = serviceOne.getDate().split("-");
                    try {
                         dateOfServiveOneAfter = new SimpleDateFormat("dd.MM.yyyy").parse(serviceOneDate[0]);
                        dateOfServiveOneBefore = new SimpleDateFormat("dd.MM.yyyy").parse(serviceOneDate[1]);

                         dateOfService = new SimpleDateFormat("dd.MM.yyyy").parse(dateService);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    return  (dateOfService.after(dateOfServiveOneAfter) && dateOfService.before(dateOfServiveOneBefore));
                })
                .collect(Collectors.toList());



        System.out.println();
        System.out.println(serviceListAfterFilter);

    }
}
