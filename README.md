# JavaMethodLoader
## Описание работы

Основная работа идёт в классе Downloader. Используется библиотека javaParser для составления и обхода AST. Для использования необходимо создать экземпляр класса, вызвать в нём метод find, передав путь к папке с пакетами и сигнатурой метода. Сигнатура берётся из сигнатуры методов в neo4j. Примеры использования можно увидеть в тестах.

## Использование в командной строке
Используем Jparser17-1.0-SNAPSHOT.jar. Первым аргуметом передаётся путь к файлу или путь к директории, где лежат корневой пакет с нужным файлом. Вторым аргументом передаётся сигнатура метода из neo4j в кавычках. В общем виде:

<pre><code>java -jar Jparser17-1.0-SNAPSHOT.jar directory_path "neo4j signature"</code></pre>

Явный пример:

<pre><code>java -jar Jparser17-1.0-SNAPSHOT.jar /Users/aleksandrsvedov/Jparser17/PacketsDirectory "&lt;clojure.lang.LazySeq: clojure.lang.ISeq seq()&gt;"
</code></pre>
