<h1>Task Description:</h1>
<p>Дана следующая информация (однако, вы можете проверить ее самостоятельно):<p/>
<ul>
<li>1 января 1900 года - понедельник;</li>
<li>В сентябре, апреле, июне и ноябре 30 дней;<br/>В феврале 28, в високосный год - 29;<br/>В остальных месяцах по 31 дню;</li>
<li>Високосный год - любой год, делящийся нацело на 4, однако первый год века (ХХ00) является високосным в том и только том случае, если делится на 400.</li>
</ul>
<p>Создать веб приожение для подсчета кол-ва выходных дней (выходными считаются суббота и воскресенье а также даты из таблицы holidays в базе данных ) между 2-мя датами.</p>
<p>Сервис доступен только юзерам, которые прошли авторизацию на странице логина!</p>
<p>Список пользователей (логин / пароль ) хранится в базе данных в таблице users.</p>
<p>После логина пользователю доступна форма для ввода начальной и конечной даты – после нажатия кнопки производится расчет кол-ва выходных дней в выводится пользователю.</p>

<h1>Task Implemetation Details:</h1>
<ul>
<li>input data is validated in tests;</li>
<li>mySQL is required to run application without additional modifications;</li>
<li>file "src/main/resources/application.properties" contains all required configuration settings; db-connection details must be set here before any tests performed;</li>
<li>project configured to "Create" database structure and fill with some data. File "src/main/resources/import.sql" contains all database initialization routines;</li>
<li>table "holidays" is filled with data for year 2016 (real holidays of 2016 in Ukraine). It is recommended but not obligatory to perform tests using this year;</li>
<li>table "users" is filled with three users: "first", "second", "third". Password is the same for all of them: "123456". All users equal in their privileges and valid for all tests;</li>
<li>internationalization is included. Supported languages: english, russian. Database values (holiday names) are not localized;</li>
