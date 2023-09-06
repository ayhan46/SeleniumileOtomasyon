import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sayfalar.AnaSayfa;
import sayfalar.GirisYapSayfasi;

public class LoginTests {

    private WebDriver driver;
    private AnaSayfa anaSayfa;
    private GirisYapSayfasi girisYapSayfasi;

    @BeforeEach
    void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        anaSayfa = new AnaSayfa(driver);
        girisYapSayfasi = new GirisYapSayfasi(driver);
        driver.get("http://www.hepsiburada.com");
    }


    @Test
    void hepsiburadaLoginTesti() {
        driver.get("http://www.hepsiburada.com");


        anaSayfa.elementGozukeneKadarBekle(anaSayfa.hesabim);
        anaSayfa.tusaBas(anaSayfa.hesabim);
        anaSayfa.elementGozukeneKadarBekle(anaSayfa.girisYap);
        anaSayfa.tusaBas(anaSayfa.girisYap);

        girisYapSayfasi.elementGozukeneKadarBekle(girisYapSayfasi.emailAdresi);
        girisYapSayfasi.alanaYaziYaz(girisYapSayfasi.emailAdresi, "ayhan.kmsgtl42@gmail.com");
        girisYapSayfasi.elementGozukeneKadarBekle(girisYapSayfasi.girisYapTusu);
        girisYapSayfasi.tusaBas(girisYapSayfasi.girisYapTusu);
    }

    @Test
    void urunAramaTest(){
        anaSayfa.elementGozukeneKadarBekleCss(anaSayfa.urunArama);
        anaSayfa.alanaYaziYazCss(anaSayfa.urunArama, "Araba");
        anaSayfa.klavyeTusunaBas(anaSayfa.urunArama, Keys.ENTER);
    }



    @AfterEach
    void tearDown(){
        driver.close();
    }

}
