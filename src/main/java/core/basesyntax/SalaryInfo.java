package core.basesyntax;

public class SalaryInfo {
    public String getSalaryInfo(String[] names, String[] data, String dateFrom, String dateTo) {
        StringBuilder result = new StringBuilder("Report for period " + dateFrom + " - " + dateTo + "\n");

        for (String name : names) {
            int totalSalary = 0;

            for (String record : data) {
                String[] parts = record.split(" ");
                String recordDate = parts[0];
                String recordName = parts[1];
                String recordHours = parts[2];
                String recordRate = parts[3];
                int hours = Integer.parseInt(recordHours);
                int rate = Integer.parseInt(recordRate);
                String day = recordDate.substring(0, 2);
                String month = recordDate.substring(3, 5);
                String year = recordDate.substring(6, 10);
                String formatedRecordDate = year + month + day;
                String fromDay = dateFrom.substring(0, 2);
                String froMonth = dateFrom.substring(3, 5);
                String fromYear = dateFrom.substring(6, 10);
                String formatedDateFrom = fromYear + froMonth + fromDay;
                String toDateDay = dateTo.substring(0, 2);
                String toDateMonth = dateTo.substring(3, 5);
                String toDateYear = dateTo.substring(6, 10);
                String formatedDayTo = toDateYear + toDateMonth + toDateDay;
                int formatedRecordData = Integer.parseInt(formatedRecordDate);
                int formatedDataFrom = Integer.parseInt(formatedDateFrom);
                int formatedDaTo = Integer.parseInt(formatedDayTo);

                if (recordName.equals(name) && formatedRecordData >= formatedDataFrom && formatedRecordData <= formatedDaTo) {
                    totalSalary += hours * rate;
                }

            }
            result.append(name).append(" - ").append(totalSalary).append("\n");
        }
        return result.toString();
    }
}

