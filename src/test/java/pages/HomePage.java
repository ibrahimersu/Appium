package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

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
}
