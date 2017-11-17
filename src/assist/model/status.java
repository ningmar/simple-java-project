/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assist.model;

/**
 *
 * @author hp
 */
public class status {
    int sid;
    double price;
    String expenses,type;

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setExpenses(String expenses) {
        this.expenses = expenses;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSid() {
        return sid;
    }

    public double getPrice() {
        return price;
    }

    public String getExpenses() {
        return expenses;
    }

    public String getType() {
        return type;
    }
}
