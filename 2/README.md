# Java_HW_2
 StringBuilder with undo, ObservableStringBuilder and other homework#2

### Я не стала делегировать все методы стандартного StringBuilder, это очень долго и бесполезно, т.к. принцип понятен и без этого.

1. Реализовать класс-обертку StringBuilder с поддержкой undo. Делегировать стандартные методы стандартному StringBuilder. Паттерн «Команда». 
(Файл: src\UndoStringBuilder.java)
2. Написать класс StringBuilder с оповещением других объектов-слушателей об изменении своего состояния.
Делегировать стандартные методы стандартному StringBuilder. Паттерн «Наблюдатель». 
(Файлы: src\ObservableStringBuilder.java, Observable.java, Observer.java, PrintObserver.java) 
3. Реализуйте метод, который на вход получает любую коллекцию и возвращает коллекцию уже без дубликатов. 
(Файл: src\DeleteDuplicates.java)
4. Реализовать частотный словарь слов русского языка (на вход принимается текст любой размерности). 
(Файлы: src\FrequencyDictionary.java, the_lion_and_the_dog.txt)
