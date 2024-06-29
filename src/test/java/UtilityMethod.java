import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.Random;

public class UtilityMethod {

    static String rfq_id="";

        public static String buildPan() {

            StringBuilder panNumbersText = new StringBuilder();
            String possibleAlphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String randomChars = "ABCFGHLJPT";
            Random random = new Random();

            for (int i = 0; i < 5; i++) {
                if (i == 3) {
                    panNumbersText.append(randomChars.charAt(random.nextInt(randomChars.length())));
                    continue;
                }
                panNumbersText.append(possibleAlphabets.charAt(random.nextInt(possibleAlphabets.length())));
            }
            panNumbersText.append(String.format("%04d", random.nextInt(10000)));

            for (int j = 0; j < 1; j++) {
                panNumbersText.append(possibleAlphabets.charAt(random.nextInt(possibleAlphabets.length())));
            }
            return panNumbersText.toString();
        }

        public static String buildGst(){

            String gst = "06"+buildPan()+"1ZC";
            return gst;
        }


//    public void getAuthToken(String token) throws InterruptedException {
//
//
//
//        String url = String.format("%s/api/v1/internal/testLogin/%s?key=%s", prop.getProperty("stg5-be-url"),token, prop.getProperty("stg5-redis-key"));
//
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(url))
//                .header("Content-Type", "application/json")
//                .build();
//
//        try {
//
//            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//            int statusCode = response.statusCode();
//
//            if (statusCode == 200) {
//                System.out.println("API call successful. Status code: 200");
//            } else {
//                System.out.println("API call failed. Status code: " + statusCode);
//            }
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    public static String getRFQ_ID()
    {
        return rfq_id;
    }

    public static void setRFQ_ID(String rfq)
    {
        rfq_id=rfq;
    }

    public static String getDataFromClipBoard()
    {
        // Get the system clipboard
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        // Get the clipboard contents
        Transferable contents = clipboard.getContents(null);

        // Check if clipboard has text data
        if (contents != null && contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            try {
                // Retrieve and print the text data from the clipboard
                String clipboardText = (String) contents.getTransferData(DataFlavor.stringFlavor);
                return clipboardText;
            } catch (UnsupportedFlavorException | IOException e) {
                System.err.println("Error retrieving clipboard data: " + e.getMessage());
            }
        } else {
            System.out.println("No text data in clipboard.");
        }
        return null;
    }

    public static Long generateAccountNumber()
    {
        Random random = new Random();
        long tenDigitNumber = 1000000000L + (long)(random.nextDouble() * 8999999999L);
        return tenDigitNumber;
    }


}
