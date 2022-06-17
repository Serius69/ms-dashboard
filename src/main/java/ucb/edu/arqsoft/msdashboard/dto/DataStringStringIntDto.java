package ucb.edu.arqsoft.msdashboard.dto;

public class DataStringStringIntDto {

    private String monthName;
    private String categoryName;
    private Integer quantity;

    public DataStringStringIntDto() {
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
