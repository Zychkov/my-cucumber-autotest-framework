package ru.zychkov.test.steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import ru.zychkov.test.pages.GooglePage;

import static com.codeborne.selenide.Selenide.open;

public class GooglePageDefs {

    GooglePage page = new GooglePage();

    @Когда("перехожу по url {string}")
    public void goToUrl(String url) {
        open(url );
    }

    @И("в ввожу в строку поиска {string}")
    public void search(String value) {
        page.search(value);
    }

    @Тогда("вижу ссылку {string}")
    public void checkLink(String link) {
        page.checkLink(link);
    }
}