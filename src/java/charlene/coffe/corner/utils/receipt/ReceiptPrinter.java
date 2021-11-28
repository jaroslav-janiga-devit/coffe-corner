package charlene.coffe.corner.utils.receipt;

import charlene.coffe.corner.management.Basket;
import charlene.coffe.corner.utils.Constants;

import java.util.List;
import java.util.stream.Collectors;

public class ReceiptPrinter {

    public static String createReceipt(Basket basket) {
        return collectReceiptItems(basket.getItems())
                + "\n"
                + String.format("\t" + Constants.MENU_ITEM_RECEIPT_FORMAT, "total price:",
                basket.totalPrice(), Constants.CURRENCY);
    }

    private static String collectReceiptItems(List<? extends ReceiptItemFormatter> receiptItems) {
        return receiptItems.stream()
                .map(ReceiptItemFormatter::formatForReceipt)
                .collect(Collectors.joining("\n"));
    }
}
