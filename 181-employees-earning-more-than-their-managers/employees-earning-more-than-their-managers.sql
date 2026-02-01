# Write your MySQL query statement below
Select e.name as "Employee"
from Employee as e
Left JOIN Employee as m
on e.managerId = m.id
where e.salary > m.salary;