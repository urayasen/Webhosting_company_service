package main;

public class Service {
    private String service_type;
    private String service_id;
    private String variation_id;
    private String question_type_id;
    private String category_id;
    private String sub_category_id;
    private String P_N;
    private String date;
    private String time;

    public Service(String service_type, String service_id, String variation_id, String question_type_id, String category_id, String sub_category_id, String p_N, String date, String time) {
        this.service_type = service_type;
        this.service_id = service_id;
        this.variation_id = variation_id;
        this.question_type_id = question_type_id;
        this.category_id = category_id;
        this.sub_category_id = sub_category_id;
        P_N = p_N;
        this.date = date;
        this.time = time;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    public String getService_id() {
        return service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    public String getVariation_id() {
        return variation_id;
    }

    public void setVariation_id(String variation_id) {
        this.variation_id = variation_id;
    }

    public String getQuestion_type_id() {
        return question_type_id;
    }

    public void setQuestion_type_id(String question_type_id) {
        this.question_type_id = question_type_id;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getSub_category_id() {
        return sub_category_id;
    }

    public void setSub_category_id(String sub_category_id) {
        this.sub_category_id = sub_category_id;
    }

    public String getP_N() {
        return P_N;
    }

    public void setP_N(String p_N) {
        P_N = p_N;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Service)) return false;

        Service service = (Service) o;

        if (getService_type() != null ? !getService_type().equals(service.getService_type()) : service.getService_type() != null)
            return false;
        if (getService_id() != null ? !getService_id().equals(service.getService_id()) : service.getService_id() != null)
            return false;
        if (getVariation_id() != null ? !getVariation_id().equals(service.getVariation_id()) : service.getVariation_id() != null)
            return false;
        if (getQuestion_type_id() != null ? !getQuestion_type_id().equals(service.getQuestion_type_id()) : service.getQuestion_type_id() != null)
            return false;
        if (getCategory_id() != null ? !getCategory_id().equals(service.getCategory_id()) : service.getCategory_id() != null)
            return false;
        if (getSub_category_id() != null ? !getSub_category_id().equals(service.getSub_category_id()) : service.getSub_category_id() != null)
            return false;
        if (getP_N() != null ? !getP_N().equals(service.getP_N()) : service.getP_N() != null) return false;
        if (getDate() != null ? !getDate().equals(service.getDate()) : service.getDate() != null) return false;
        return getTime() != null ? getTime().equals(service.getTime()) : service.getTime() == null;
    }

    @Override
    public int hashCode() {
        int result = getService_type() != null ? getService_type().hashCode() : 0;
        result = 31 * result + (getService_id() != null ? getService_id().hashCode() : 0);
        result = 31 * result + (getVariation_id() != null ? getVariation_id().hashCode() : 0);
        result = 31 * result + (getQuestion_type_id() != null ? getQuestion_type_id().hashCode() : 0);
        result = 31 * result + (getCategory_id() != null ? getCategory_id().hashCode() : 0);
        result = 31 * result + (getSub_category_id() != null ? getSub_category_id().hashCode() : 0);
        result = 31 * result + (getP_N() != null ? getP_N().hashCode() : 0);
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        result = 31 * result + (getTime() != null ? getTime().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Service{" +
                "service_type='" + service_type + '\'' +
                ", service_id='" + service_id + '\'' +
                ", variation_id='" + variation_id + '\'' +
                ", question_type_id='" + question_type_id + '\'' +
                ", category_id='" + category_id + '\'' +
                ", sub_category_id='" + sub_category_id + '\'' +
                ", P_N='" + P_N + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}'+ '\n';
    }
}
