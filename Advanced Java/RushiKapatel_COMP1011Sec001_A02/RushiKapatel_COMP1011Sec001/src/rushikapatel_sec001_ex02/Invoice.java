package rushikapatel_sec001_ex02;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Invoice {
    private final String partNumber;
    private final String partDescription;
    private int quantity;
    private double pricePerItem;

    // constructor
    public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) {
        if (quantity < 0) { // validate quantity
            throw new IllegalArgumentException("Quantity must be larger than 0");
        }

        if (pricePerItem < 0.0) { // validate pricePerItem
            throw new IllegalArgumentException("Price per item must be greater than 0");
        }
        this.quantity = quantity;
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        this.pricePerItem = pricePerItem;
    }

    // get part number
    public String getPartNumber() {
        return partNumber;
    }

    // get description
    public String getPartDescription() {
        return partDescription;
    }

    // set quantity
    public void setQuantity(int quantity) {
        if (quantity < 0) { // validate quantity
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }

        this.quantity = quantity;
    }

    // get quantity
    public int getQuantity() {
        return quantity;
    }

    // set price per item
    public void setPricePerItem(double pricePerItem) {
        if (pricePerItem < 0.0) {// validate pricePerItem
            throw new IllegalArgumentException("Price per item must be greater than 0");
        }

        this.pricePerItem = pricePerItem;
    }

    // get price per item
    public double getPricePerItem() {
        return pricePerItem;
    }

    // return String representation of Invoice object
    @Override
    public String toString() {
        return String.format("%s: %n%s: %s (%s) %n%s: %d %n%s: $%,.2f",
                "invoice", "part number", getPartNumber(), getPartDescription(),
                "quantity", getQuantity(), "price per item", getPricePerItem());
    }

    // return amount of this Invoice
    public double getInvoiceAmount() {
        return getQuantity() * getPricePerItem(); // calculate total cost
    }

    public static void main(String[] args) {
        // Sample data
        Invoice[] invoices = {
                new Invoice("56", "Jig Saw", 21, 11.0),
                new Invoice("77", "Hammer", 76, 12.99),
                new Invoice("68", "Screwdriver", 106, 6.99),
                new Invoice("87", "Electric Sander", 7, 57.98)
        };

        // Convert array to list for easier manipulation with streams
        List<Invoice> invoiceList = Arrays.asList(invoices);

        // a) Sorting invoices by partDescription
        List<Invoice> sortedByPartDescription = invoiceList.stream()
                .sorted(Comparator.comparing(Invoice::getPartDescription))
                .collect(Collectors.toList());
        System.out.println("Sorted by Part Description:");
        sortedByPartDescription.forEach(System.out::println);

        System.out.println();

        // b) Sorting invoices by pricePerItem
        List<Invoice> sortedByPricePerItem = invoiceList.stream()
                .sorted(Comparator.comparing(Invoice::getPricePerItem))
                .collect(Collectors.toList());
        System.out.println("Sorted by Price Per Item:");
        sortedByPricePerItem.forEach(System.out::println);

        System.out.println();

        // c) Mapping each invoice to its partDescription and quantity, then sorting by quantity
        List<String> partDescAndQuantity = invoiceList.stream()
                .map(invoice -> invoice.getPartDescription() + " - " + invoice.getQuantity())
                .sorted(Comparator.comparing(str -> Integer.parseInt(str.split(" - ")[1])))
                .collect(Collectors.toList());
        System.out.println("Part Description and Quantity, sorted by Quantity:");
        partDescAndQuantity.forEach(System.out::println);

        System.out.println();

        // d) Mapping each invoice to its partDescription and value (quantity * pricePerItem), then sorting by invoice value
        List<String> partDescAndValue = invoiceList.stream()
                .map(invoice -> invoice.getPartDescription() + " - $" + invoice.getInvoiceAmount())
                .sorted(Comparator.comparing(str -> Double.parseDouble(str.split(" - ")[1].substring(1))))
                .collect(Collectors.toList());
        System.out.println("Part Description and Value, sorted by Invoice Value:");
        partDescAndValue.forEach(System.out::println);

        System.out.println();

        // e) Filtering invoices with value in range $200 to $500
        List<String> partDescAndValueInRange = invoiceList.stream()
                .filter(invoice -> invoice.getInvoiceAmount() >= 200 && invoice.getInvoiceAmount() <= 500)
                .map(invoice -> invoice.getPartDescription() + " - $" + invoice.getInvoiceAmount())
                .collect(Collectors.toList());
        System.out.println("Part Description and Value in range $200 to $500:");
        partDescAndValueInRange.forEach(System.out::println);

        System.out.println();

        // f) Finding any invoice with partDescription containing the word "saw"
        Invoice sawInvoice = invoiceList.stream()
                .filter(invoice -> invoice.getPartDescription().toLowerCase().contains("saw"))
                .findFirst()
                .orElse(null);
        System.out.println("Invoice with Part Description containing 'saw':");
        if (sawInvoice != null) {
            System.out.println(sawInvoice);
        } else {
            System.out.println("No invoice found with partDescription containing 'saw'.");
        }
    }
}
