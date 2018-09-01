#include <stdio.h>
#include <stdlib.h>

struct time
{
    int hours;
    int minutes;
};

void day_time(struct time* sunrise, struct time* sunset, struct time* result)
{
    int minutes = (sunset->hours - sunrise->hours) * 60 + sunset->minutes - sunrise->minutes;
    result->hours = minutes / 60;
    result->minutes = minutes % 60;
}

int main()
{
    struct time sunrise, sunset;
    struct time* result = (struct time*)malloc(sizeof(struct time*));
    char month[10], day[3], year[5];
    while(scanf("%s %s %s %d:%d %d:%d", month, day, year, &sunrise.hours, &sunrise.minutes, &sunset.hours, &sunset.minutes) == 7)
    {
        day_time(&sunrise, &sunset, result);
        printf("%s %s %s %d hours %d minutes\n", month, day, year, result->hours, result->minutes);
    }
    free(result);
    return 0;
}