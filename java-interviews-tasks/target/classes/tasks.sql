/*
Задание 1
Постройте запрос, который выводит из Table1 только те записи(строки), которых нет в таблице Table2,
включая повторы (в решении нельзя использовать except, minus и intersect).

Table 1
ID	NAME
1	Name1
1	Name1
2	Name2
2	Name2
4	Name3

Table 2
ID	NAME
2	Name2
2	Name3
3	Name3
4	Name4
4	Name4
*/

/* Через not in */
select table1.* from table1 where (table1.id, table1.name) not in (SELECT * from table2)

/* Через not exists */
select table1.* from table1 where not exists ( select * from table2 where table2.id = table1.id and table2.name = table1.name)

/*
Задание 2
Для тех же таблиц постройте запрос, который выводит только те записи(строки) Table1, которые есть в Table2,
исключая повторы (в решении нельзя использовать except, minus и intersect).
*/

/* Через in */
select distinct table1.* from table1 where (table1.id, table1.name) in (SELECT * from table2)

/* Через exists */
select distinct table1.* from table1 where exists ( select * from table2 where table2.id = table1.id and table2.name = table1.name)

/*
Задание 3
В базе данных таксопарка есть три таблицы.
1) Таблица "driver", которая содержит информацию о водителях таксопарка. Она содержит поля:
    "id" - уникальный идентификатор водителя;
    "first_name" - имя водителя;
    "last_name" - фамилия водителя;
    "birth_date" - дата рождения водителя.
2) Таблица "car", которая содержит информацию об автомобилях таксопарка. Она содержит поля:
    "id" - уникальный идентификатор автомобиля;
    "brand" - марка автомобиля;
    "manufacturing_year" - год выпуска автомобиля;
    "mileage" - пробег автомобиля.
3) Таблица "car_driver", которая содержит информацию о том, какой автомобиль закреплен за каким водителем. Она содержит поля:
    "id" - уникальный идентификатор записи;
    "car_id" - идентификатор автомобиля;
    "driver_id" - идентификатор водителя, за которым закреплен автомобиль.
Обратите внимание, что за одним водителем может быть закреплено более одного автомобиля, а у одного автомобиля может быть несколько водителей.

Исходя из описания и схемы базы данных, составьте SQL-запрос, результатом которого будет список фамилий водителей, за которыми закреплено два или более автомобиля марки Toyota.
*/

select driver.last_name from driver
    left join car_driver on driver.id = car_driver.driver_id
    left join car on car_driver.car_id = car.id
where car.brand = 'Toyota'
group by driver.id
having count(car.brand = 'Toyota') > 1

