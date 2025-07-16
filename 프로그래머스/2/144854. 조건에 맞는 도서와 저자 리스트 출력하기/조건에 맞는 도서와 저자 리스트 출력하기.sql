select BOOK_ID, AUTHOR_NAME, date_format(PUBLISHED_DATE,'%Y-%m-%d') as 'PUBLISHED_DATE'
from BOOK b left join author a
on b.AUTHOR_ID = a.AUTHOR_ID
where category='경제'
ORDER BY PUBLISHED_DATE