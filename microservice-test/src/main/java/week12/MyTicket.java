package week12;

public class MyTicket implements TicketInterface{

    private static int ticketNumber = -1;
    private String color;

    public MyTicket(String color) {
        this.color = color;
    }

    @Override
    public int gerNumber() {
        ticketNumber = ticketNumber+1;
        return ticketNumber;
    }


    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return getColor()+":"+gerNumber();
    }
}
