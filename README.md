Проект сделан на основе фреймворков Cucumber, Junit5 и Selenide

Тесты запускаются командой `./gradlew -Dcourgette.threads=3 -Dcucumber.tags="@$cucumberTag" -PselenoidBrowser="$browser" clean test -i`,
где:
 - $cucumberTag и $browser можно передавать в качестве переменных;
 - courgette.threads - количество потоков.


#### **Allure отчет**
Если необходимо формирование Allure отчета, то после запуска тестов последовательно вызываем команды:
`./gradlew allureReport`
`./gradlew allureServe`


#### **Запуск тестов на Selenoid**
https://aerokube.com/selenoid/latest/

1. Для запуска Selenoid необходим Docker
2. Скачиваем Download Configuration Manager:  https://github.com/aerokube/cm/releases
3. Делаем скачанный файл исполняемым. На Linux выполнить команду: `chmod +x cm`
4. Запускаем Selenoid*: `./cm selenoid start --vnc --tmpfs 256 --force`
5. Запускаем Selenoid-UI*: `./cm selenoid-ui start`
6. Проверяем, что Seleniod запущен. Например, если запуск на localhost, то заходим на http://localhost:4444/status и http://localhost:8080/

*если необходимо сменить порт, то при вызове указываем номер порта через ключ `--port `

Если необходимо отключить запуск тестов через Selenoid, то нужно в test.properties в параметре `browser` указать нужный браузер.