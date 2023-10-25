info: https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html

Nested classes:
    1) static. See krev/oop_principles/nestedClasses/OuterClass.java (StaticNestedClass)
    2) non-static = inner
        a) 'usual' inside outer class. See krev/oop_principles/nestedClasses/OuterClass.java (InnerClass)
        b) local (inside body of method of outer class) See krev/oop_principles/nestedClasses/LocalClass.java
        c) anonymous (local without name). See krev/oop_principles/nestedClasses/AnonymousClassesTest.java

ИЛИ
info: https://javastudy.ru/interview/java-oop2/
37. Какие типы классов бывают в java (вложенные… и.т.д.)
38. Какие особенности создания вложенных классов: простых и статических.
    a) Обычные классы (Top level classes)
    b) Интерфейсы (Interfaces)
    c) Перечисления (Enum)
    d) Статические вложенные классы (Static nested classes)
        - Есть возможность обращения к внутренним статическим полям и методам класса обертки.
        - Внутренние статические классы могут содержать только статические методы.
    e) НЕстатические вложенные классы:
        i. Внутренние классы-члены (Member inner classes)
            - Есть возможность обращения к внутренним полям и методам класса обертки.
            - Не может иметь статических объявлений.
            - Нельзя объявить таким образом интерфейс. А если его объявить без идентификатора static, то он автоматически будет добавлен.
            - Внутри такого класса нельзя объявить перечисления.
            - Если нужно явно получить this внешнего класса — OuterClass.this
        ii) Локальный класс (Local inner classes)
            - Видны только в пределах блока, в котором объявлены.
            - Не могут быть объявлены как private/public/protected или static (по этой причине интерфейсы нельзя объявить локально).
            - Не могут иметь внутри себя статических объявлений (полей, методов, классов).
            - Имеют доступ к полям и методам обрамляющего класса.
            - Можно обращаться к локальным переменным и параметрам метода, если они объявлены с модификатором final или являются effective final
        iii) Анонимные классы (Anonymous inner classes)
            - как Локальный класс, НО без имени.

Критерии:
    к каким внешним переменным и методам могут обращаться
    shadow внешних переменных