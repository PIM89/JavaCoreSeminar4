# JavaCoreSeminar4
## Урок 4. Обработка исключений
1. В класс Товаров добавить перечисление с категориями товаров, добавить в Товар поле категория со значением созданного перечисления. Добавить геттеры, сеттеры.
2. Добавить перечисление с размерами скидок - 0, 5, 10, 15, 20%. Написать метод, при вызове которого на переданную категорию товара незначается рандомная скидка из перечисления. Добавить в заказ поле стоимость и пересчитать стоимость согласно сгенерированным скидкам.
3. Если сумма величин скидок на товары из заказа получилась больше 50%, выбросить исключение TooMuchSaleException(); Создать заказ с общей скидкой 20%. То есть нужно сложить величины скидок на категории и проверить больше 50 или нет.
