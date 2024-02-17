# Write your MySQL query statement below
select
    Person.firstName,
    Person.lastName,
    Address.city,
    Address.state      
from Person as Person
    left join Address as Address
    on Person.personId = Address.personId    