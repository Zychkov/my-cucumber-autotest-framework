# language: ru

@example
Функция: Поиск в Google

  Сценарий: Поиск фразы "Cucumber framework"
    Когда перехожу по url "https://www.google.com/"
    И в ввожу в строку поиска "Cucumber framework"
    Тогда вижу ссылку "https://cucumber.io/"