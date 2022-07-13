from datetime import datetime, timedelta


def date_converter(values):
    range_between = {}
    date_range_start = values[0]
    date_range_end = values[1]
    if date_range_start is not None and date_range_end is not None:
        today = datetime.today()
        max_date_to_rest = timedelta(days=14)
        d = today - max_date_to_rest
        date_format = "%d/%m/%Y"
        a = datetime.strptime(date_range_start, date_format)
        b = datetime.strptime(date_range_end, date_format)
        if a.days > b.days:
            raise
        else:
            if a.days - d.days < 0:
                raise
            else:
                a = a.strftime("%m/%d/%Y")
                b = b.strftime("%m/%d/%Y")
                range_between = {0: a, 1: b}

    return range_between


def convert_date(values):
    date_range_start = values[0]
    date_range_end = values[1]

    data = {
        0: datetime.strptime(date_range_start, '%Y-%m-%d').strftime('%m/%d/%Y'),
        1: datetime.strptime(date_range_end, '%Y-%m-%d').strftime('%m/%d/%Y'),
        2: date_range_start,
        3: date_range_end
    }

    return data
