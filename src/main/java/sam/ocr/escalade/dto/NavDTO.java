package sam.ocr.escalade.dto;

import java.util.ArrayList;
import java.util.List;

public class NavDTO {

    List<NavItem> items;
    NavItem previous;
    NavItem next;

    public NavDTO() {
        items = new ArrayList<>();
    }

    public NavItem getPrevious() {
        return previous;
    }

    public void setPrevious(NavItem previous) {
        this.previous = previous;
    }

    public NavItem getNext() {
        return next;
    }

    public void setNext(NavItem next) {
        this.next = next;
    }

    public List<NavItem> getItems() {
        return items;
    }

    public void setItems(List<NavItem> items) {
        this.items = items;
    }

    public void addItem(int number, boolean isCurrent) {
        items.add(new NavItem(number, isCurrent));
    }

    public void addPrevious(int number){
        this.setPrevious(new NavItem(number));
    }

    public void addNext(int number){
        this.setNext(new NavItem(number));
    }

    public class NavItem {
        private int number;
        private boolean isCurrent;

        NavItem(int number, boolean isCurrent) {
            this.number = number;
            this.isCurrent = isCurrent;
        }

        NavItem(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public boolean isCurrent() {
            return isCurrent;
        }

        public void setCurrent(boolean current) {
            isCurrent = current;
        }
    }
}
