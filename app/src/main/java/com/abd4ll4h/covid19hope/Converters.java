/*
 * Copyright 2019 Shawn Wang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.abd4ll4h.covid19hope;

import androidx.room.TypeConverter;

import java.util.Calendar;
import java.util.Date;

/**
 * Type converters to allow Room to reference complex data types.
 */
public class Converters {

    @TypeConverter
    public String calendarToDatestamp(Calendar calendar) {

        return calendar.getTime().toString();
    }

    @TypeConverter
    public Calendar datestampToCalendar(String  value) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(value));
        return calendar;
    }
}
