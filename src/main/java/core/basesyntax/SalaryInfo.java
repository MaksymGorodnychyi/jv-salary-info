package core.basesyntax;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SalaryInfo {
    private static final int DATE_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int HOURS_INDEX = 2;
    private static final int RATE_INDEX = 3;
    private static final String LINE_SEPARATOR = System.lineSeparator();

    public String getSalaryInfo(String[] names, String[] data, String dateFrom, String dateTo) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate fromDate = LocalDate.parse(dateFrom, formatter);
        LocalDate toDate = LocalDate.parse(dateTo, formatter);
        StringBuilder result = new StringBuilder(
                "Report for period " + dateFrom + " - " + dateTo + LINE_SEPARATOR);

        for (String name : names) {
            int totalSalary = 0;

            for (String record : data) {
                String[] parts = record.split(" ");
                String recordDate = parts[DATE_INDEX];
                String recordName = parts[NAME_INDEX];
                LocalDate currentDate = LocalDate.parse(recordDate, formatter);
                boolean isAfterOrEqualDate = currentDate.isAfter(fromDate)
                        || currentDate.isEqual(fromDate);
                boolean isBeforeOrEqualDate = currentDate.isBefore(toDate)
                        || currentDate.isEqual(toDate);
                int hours = Integer.parseInt(parts[HOURS_INDEX]);
                int rate = Integer.parseInt(parts[RATE_INDEX]);

                if (recordName.equals(name)
                        && isAfterOrEqualDate
                        && isBeforeOrEqualDate) {
                    totalSalary += hours * rate;
                }

            }
            result.append(name).append(" - ").append(totalSalary).append(LINE_SEPARATOR);
        }
        return result.toString();
    }
}

