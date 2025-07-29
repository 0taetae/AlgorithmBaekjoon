SELECT ai.NAME, ai.DATETIME
FROM ANIMAL_INS ai left join ANIMAL_OUTS ao
on ai.ANIMAL_ID = ao.ANIMAL_ID
where ao.DATETIME is null
order by ai.DATETIME limit 3