SELECT USER_ID, 
    NICKNAME, 
    CONCAT(CITY, ' ',STREET_ADDRESS1, ' ', STREET_ADDRESS2) AS 전체주소,
    CONCAT(SUBSTR(TLNO,1, 3), '-', SUBSTR(TLNO, 4, 4), '-', SUBSTR(TLNO, 8, 4)) as '전화번호'
    
from USED_GOODS_BOARD b left join USED_GOODS_USER u
on b.WRITER_ID = u.USER_ID
group by u.USER_ID
having count(STATUS='DONE')>=3
order by USER_ID DESC