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

