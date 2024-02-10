package playwrightsessions;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.FilePayload;

public class MultipleFileUpload {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();

        Page page = context.newPage();

        page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");

        // page.setInputFiles("input#filesToUpload", Paths.get("applogin.json"));

        page.setInputFiles("input#filesToUpload",
                new Path[] {
                        Paths.get("applogin.json"),
                        Paths.get("Button_Visibility.html")
                });

        Locator fileUploaded = page.locator("//ul[@id='fileList']/li");
        fileUploaded.allInnerTexts().forEach(e -> System.out.println("File Uploaded: " + e));

        // create run time file and upload
        page.setInputFiles("input#filesToUpload", new FilePayload("ritesh.txt", "text/plain",
                "testing creation of text file on run time".getBytes(StandardCharsets.UTF_8)));
        
        page.close();

        // validating the content of the uploaded file
        Page page1 = context.newPage();
        page1.navigate("https://cgi-lib.berkeley.edu/ex/fup.html");
        String text = "testing creation of text file on run time";
        page1.setInputFiles("input[name='upfile']",
                new FilePayload("ritesh.txt", "text/plain", text.getBytes(StandardCharsets.UTF_8)));
        page1.click("input[value='Press']");

        page1.close();
        context.close();
        playwright.close();

    }
}
