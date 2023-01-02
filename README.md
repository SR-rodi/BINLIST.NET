# **BINLIST.NET**
## Тестовое задание по API : https://binlist.net/

##### Пользователь вводит BIN банковской карты и видит всю доступную информацию о нём

Используемый стек:
- Room;
- Retrofit;
- Koin
- Kotlin Coroutines
- Flow
- CollapsingToolbarLayout
- Clean Architecture
- build.gradle.kts с использованием buildSrc

Кратко про приложение. Пользователь вводит BIN, и получает базовою информацию по номеру, такие как наименование банка, тип карточки, страну и другую информацию.
Пользователю доступны кнопки по клику на которые его переадресует на звонилку, карту, или сайт банка соответственно (если имеется данная информация).
Также все запросы кэшируются в базе данных и выводятся списком. Из списка также доступны данные кнопки. Любой не нужный элемент списка можно удалить свайпом в лево по этому.

<p float="left">
<img src="https://github.com/SR-rodi/BINLIST.NET/blob/main/screen/search.jfif" width=20% height=20%>
 <img src="https://github.com/SR-rodi/BINLIST.NET/blob/main/screen/list.jfif" width=20% height=20%>
</p>
