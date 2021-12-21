package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.java.an.E;
import io.cucumber.java.bs.A;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.MobileUtils;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage {
    @AndroidFindBy(id = "com.etsy.android:id/search_src_text")
    private MobileElement searchInput;

    @AndroidFindBy(accessibility = "Show Navigation Drawer")
    private MobileElement searchIcon;

    @AndroidFindBy(id = "com.etsy.android:id/listing_title")
    private List<MobileElement> searchResults;

    @AndroidFindBy(id = "com.etsy.android:id/query_text")
    private List<MobileElement> prepopulatedSearchResults;

    public HomePage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    public void searchFor(String text) {
        MobileUtils.waitFor(4000);
        MobileUtils.clickWithWait(searchIcon);

        MobileUtils.waitFor(4000);
        Actions actions = new Actions(Driver.getDriver());
//        searchInput.sendKeys(text);
        int counter = 1;
        do {
            try {
                MobileElement e = Driver.getDriver().findElement(By.xpath("com.etsy.android:id/search_src_text"));
                actions.sendKeys(e, text).perform();
                break;
            } catch (Exception e){
                System.out.println("failed to enter text. attempt :: " + counter);
                MobileUtils.waitFor(500);
            }
        } while (++counter < 10);

        MobileUtils.waitFor(2000);
        prepopulatedSearchResults.get(0).click();

        MobileUtils.waitFor(4000);
    }

    /**
     * This method returns collection of search result titles.
     * @return collections of search result titles
     */
    public List<String> getSearchResultTexts(){
        MobileUtils.waitFor(4000);
        // :: - method reference  ClassName::method
        // map(MobileElement::getText). -- apply getText method from MobileElement class to every element of the collection
        //  collect(Collectors.toList()); - create a new collection for elements
        return searchResults.stream().map(MobileElement::getText).collect(Collectors.toList());
    }
}
