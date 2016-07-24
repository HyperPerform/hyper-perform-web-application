package me.hyperperform.event;

public class MockEvent
{
    public static String gitPushEvent = "{\n" +
            "  \"ref\": \"refs/heads/changes\",\n" +
            "  \"before\": \"9049f1265b7d61be4a8904a9a27120d2064dab3b\",\n" +
            "  \"after\": \"0d1a26e67d8f5eaf1f6ba5c57fc3c7d91ac0fd1c\",\n" +
            "  \"created\": false,\n" +
            "  \"deleted\": false,\n" +
            "  \"forced\": false,\n" +
            "  \"base_ref\": null,\n" +
            "  \"compare\": \"https://github.com/baxterthehacker/public-repo/compare/9049f1265b7d...0d1a26e67d8f\",\n" +
            "  \"commits\": [\n" +
            "    {\n" +
            "      \"id\": \"0d1a26e67d8f5eaf1f6ba5c57fc3c7d91ac0fd1c\",\n" +
            "      \"tree_id\": \"f9d2a07e9488b91af2641b26b9407fe22a451433\",\n" +
            "      \"distinct\": true,\n" +
            "      \"message\": \"Update README.md\",\n" +
            "      \"timestamp\": \"2015-05-05T19:40:15-04:00\",\n" +
            "      \"url\": \"https://github.com/baxterthehacker/public-repo/commit/0d1a26e67d8f5eaf1f6ba5c57fc3c7d91ac0fd1c\",\n" +
            "      \"author\": {\n" +
            "        \"name\": \"baxterthehacker\",\n" +
            "        \"email\": \"baxterthehacker@users.noreply.github.com\",\n" +
            "        \"username\": \"baxterthehacker\"\n" +
            "      },\n" +
            "      \"committer\": {\n" +
            "        \"name\": \"baxterthehacker\",\n" +
            "        \"email\": \"baxterthehacker@users.noreply.github.com\",\n" +
            "        \"username\": \"baxterthehacker\"\n" +
            "      },\n" +
            "      \"added\": [\n" +
            "\n" +
            "      ],\n" +
            "      \"removed\": [\n" +
            "\n" +
            "      ],\n" +
            "      \"modified\": [\n" +
            "        \"README.md\"\n" +
            "      ]\n" +
            "    }\n" +
            "  ],\n" +
            "  \"head_commit\": {\n" +
            "    \"id\": \"0d1a26e67d8f5eaf1f6ba5c57fc3c7d91ac0fd1c\",\n" +
            "    \"tree_id\": \"f9d2a07e9488b91af2641b26b9407fe22a451433\",\n" +
            "    \"distinct\": true,\n" +
            "    \"message\": \"Update README.md\",\n" +
            "    \"timestamp\": \"2015-05-05T19:40:15-04:00\",\n" +
            "    \"url\": \"https://github.com/baxterthehacker/public-repo/commit/0d1a26e67d8f5eaf1f6ba5c57fc3c7d91ac0fd1c\",\n" +
            "    \"author\": {\n" +
            "      \"name\": \"baxterthehacker\",\n" +
            "      \"email\": \"baxterthehacker@users.noreply.github.com\",\n" +
            "      \"username\": \"baxterthehacker\"\n" +
            "    },\n" +
            "    \"committer\": {\n" +
            "      \"name\": \"baxterthehacker\",\n" +
            "      \"email\": \"baxterthehacker@users.noreply.github.com\",\n" +
            "      \"username\": \"baxterthehacker\"\n" +
            "    },\n" +
            "    \"added\": [\n" +
            "\n" +
            "    ],\n" +
            "    \"removed\": [\n" +
            "\n" +
            "    ],\n" +
            "    \"modified\": [\n" +
            "      \"README.md\"\n" +
            "    ]\n" +
            "  },\n" +
            "  \"repository\": {\n" +
            "    \"id\": 35129377,\n" +
            "    \"name\": \"public-repo\",\n" +
            "    \"full_name\": \"baxterthehacker/public-repo\",\n" +
            "    \"owner\": {\n" +
            "      \"name\": \"baxterthehacker\",\n" +
            "      \"email\": \"baxterthehacker@users.noreply.github.com\"\n" +
            "    },\n" +
            "  },\n" +
            "  \"pusher\": {\n" +
            "    \"name\": \"baxterthehacker\",\n" +
            "    \"email\": \"baxterthehacker@users.noreply.github.com\"\n" +
            "  },\n" +
            "  \"sender\": {\n" +
            "    \"login\": \"baxterthehacker\",\n" +
            "    \"id\": 6752317,\n" +
            "    \"avatar_url\": \"https://avatars.githubusercontent.com/u/6752317?v=3\",\n" +
            "    \"gravatar_id\": \"\",\n" +
            "    \"url\": \"https://api.github.com/users/baxterthehacker\",\n" +
            "    \"html_url\": \"https://github.com/baxterthehacker\",\n" +
            "    \"followers_url\": \"https://api.github.com/users/baxterthehacker/followers\",\n" +
            "    \"following_url\": \"https://api.github.com/users/baxterthehacker/following{/other_user}\",\n" +
            "    \"gists_url\": \"https://api.github.com/users/baxterthehacker/gists{/gist_id}\",\n" +
            "    \"starred_url\": \"https://api.github.com/users/baxterthehacker/starred{/owner}{/repo}\",\n" +
            "    \"subscriptions_url\": \"https://api.github.com/users/baxterthehacker/subscriptions\",\n" +
            "    \"organizations_url\": \"https://api.github.com/users/baxterthehacker/orgs\",\n" +
            "    \"repos_url\": \"https://api.github.com/users/baxterthehacker/repos\",\n" +
            "    \"events_url\": \"https://api.github.com/users/baxterthehacker/events{/privacy}\",\n" +
            "    \"received_events_url\": \"https://api.github.com/users/baxterthehacker/received_events\",\n" +
            "    \"type\": \"User\",\n" +
            "    \"site_admin\": false\n" +
            "  }\n" +
            "}";

    public static String calendarEvent = "{\n" +
            " \"kind\": \"calendar#events\",\n" +
            " \"etag\": \"\\\"p33o9vuvvs66cs0g\\\"\",\n" +
            " \"summary\": \"Test Calendar\",\n" +
            " \"description\": \"\",\n" +
            " \"updated\": \"2016-07-24T18:49:18.166Z\",\n" +
            " \"timeZone\": \"Africa/Johannesburg\",\n" +
            " \"accessRole\": \"owner\",\n" +
            " \"defaultReminders\": [\n" +
            " ],\n" +
            " \"nextSyncToken\": \"CPCf-__hjM4CEPCf-__hjM4CGAU=\",\n" +
            " \"items\": [\n" +
            "  {\n" +
            "\n" +
            "   \"kind\": \"calendar#event\",\n" +
            "   \"etag\": \"\\\"2938182153886000\\\"\",\n" +
            "   \"id\": \"4j540gah3cqn78sld9eg9bmtqg\",\n" +
            "   \"status\": \"confirmed\",\n" +
            "   \"htmlLink\": \"https://www.google.com/calendar/event?eid=NGo1NDBnYWgzY3FuNzhzbGQ5ZWc5Ym10cWcgaGszNDg3Z2Q3aDU3b2g5ZzcxaGU5dGZqczBAZw\",\n" +
            "   \"created\": \"2016-07-21T08:51:16.000Z\",\n" +
            "   \"updated\": \"2016-07-21T08:51:16.943Z\",\n" +
            "   \"summary\": \"Test\",\n" +
            "   \"description\": \"Just testing this calendar event.\",\n" +
            "   \"location\": \"Hatfield, Pretoria, 0083, South Africa\",\n" +
            "   \"creator\": {\n" +
            "    \"email\": \"hyperperformteam@gmail.com\"\n" +
            "   },\n" +
            "   \"organizer\": {\n" +
            "    \"email\": \"hk3487gd7h57oh9g71he9tfjs0@group.calendar.google.com\",\n" +
            "    \"displayName\": \"Test Calendar\",\n" +
            "    \"self\": true\n" +
            "   },\n" +
            "   \"start\": {\n" +
            "    \"dateTime\": \"2016-07-17T00:30:00+02:00\"\n" +
            "   },\n" +
            "   \"end\": {\n" +
            "    \"dateTime\": \"2016-07-17T01:30:00+02:00\"\n" +
            "   },\n" +
            "   \"iCalUID\": \"4j540gah3cqn78sld9eg9bmtqg@google.com\",\n" +
            "   \"sequence\": 0,\n" +
            "   \"reminders\": {\n" +
            "    \"useDefault\": true\n" +
            "   }\n" +
            "  },\n" +
            "  {\n" +
            "\n" +
            "   \"kind\": \"calendar#event\",\n" +
            "   \"etag\": \"\\\"2938562032676000\\\"\",\n" +
            "   \"id\": \"sk0t2sj8bgaonf67uo00maib74\",\n" +
            "   \"status\": \"confirmed\",\n" +
            "   \"htmlLink\": \"https://www.google.com/calendar/event?eid=c2swdDJzajhiZ2FvbmY2N3VvMDBtYWliNzQgaGszNDg3Z2Q3aDU3b2g5ZzcxaGU5dGZqczBAZw\",\n" +
            "   \"created\": \"2016-07-23T13:21:08.000Z\",\n" +
            "   \"updated\": \"2016-07-23T13:36:56.338Z\",\n" +
            "   \"summary\": \"Test2\",\n" +
            "   \"description\": \"Second mock event to test functionality.\",\n" +
            "   \"location\": \"Meeting Room 3\",\n" +
            "   \"colorId\": \"9\",\n" +
            "   \"creator\": {\n" +
            "    \"email\": \"hyperperformteam@gmail.com\"\n" +
            "   },\n" +
            "   \"organizer\": {\n" +
            "    \"email\": \"hk3487gd7h57oh9g71he9tfjs0@group.calendar.google.com\",\n" +
            "    \"displayName\": \"Test Calendar\",\n" +
            "    \"self\": true\n" +
            "   },\n" +
            "   \"start\": {\n" +
            "    \"dateTime\": \"2016-07-24T13:00:00+02:00\"\n" +
            "   },\n" +
            "   \"end\": {\n" +
            "    \"dateTime\": \"2016-07-24T14:00:00+02:00\"\n" +
            "   },\n" +
            "   \"iCalUID\": \"sk0t2sj8bgaonf67uo00maib74@google.com\",\n" +
            "   \"sequence\": 0,\n" +
            "   \"attendees\": [\n" +
            "    {\n" +
            "     \"email\": \"u14405025@tuks.co.za\",\n" +
            "     \"responseStatus\": \"declined\"\n" +
            "    },\n" +
            "    {\n" +
            "     \"email\": \"gordz.gordon@gmail.com\",\n" +
            "     \"displayName\": \"Jason Gordon\",\n" +
            "     \"responseStatus\": \"accepted\"\n" +
            "    },\n" +
            "    {\n" +
            "     \"email\": \"gordonjdgo@gmail.com\",\n" +
            "     \"responseStatus\": \"tentative\"\n" +
            "    },\n" +
            "    {\n" +
            "     \"email\": \"hyperperformteam@gmail.com\",\n" +
            "     \"responseStatus\": \"needsAction\"\n" +
            "    }\n" +
            "   ],\n" +
            "   \"reminders\": {\n" +
            "    \"useDefault\": true\n" +
            "   }\n" +
            "  },\n" +
            "  {\n" +
            "\n" +
            "   \"kind\": \"calendar#event\",\n" +
            "   \"etag\": \"\\\"2938712515030000\\\"\",\n" +
            "   \"id\": \"iu20v07rf5fk3vjhf56vf2aia4\",\n" +
            "   \"status\": \"confirmed\",\n" +
            "   \"htmlLink\": \"https://www.google.com/calendar/event?eid=aXUyMHYwN3JmNWZrM3ZqaGY1NnZmMmFpYTQgaGszNDg3Z2Q3aDU3b2g5ZzcxaGU5dGZqczBAZw\",\n" +
            "   \"created\": \"2016-07-24T10:30:57.000Z\",\n" +
            "   \"updated\": \"2016-07-24T10:30:57.515Z\",\n" +
            "   \"summary\": \"Test3\",\n" +
            "   \"description\": \"3rd test\",\n" +
            "   \"colorId\": \"1\",\n" +
            "   \"creator\": {\n" +
            "    \"email\": \"hyperperformteam@gmail.com\"\n" +
            "   },\n" +
            "   \"organizer\": {\n" +
            "    \"email\": \"hk3487gd7h57oh9g71he9tfjs0@group.calendar.google.com\",\n" +
            "    \"displayName\": \"Test Calendar\",\n" +
            "    \"self\": true\n" +
            "   },\n" +
            "   \"start\": {\n" +
            "    \"date\": \"2016-07-26\"\n" +
            "   },\n" +
            "   \"end\": {\n" +
            "    \"date\": \"2016-07-27\"\n" +
            "   },\n" +
            "   \"transparency\": \"transparent\",\n" +
            "   \"iCalUID\": \"iu20v07rf5fk3vjhf56vf2aia4@google.com\",\n" +
            "   \"sequence\": 0,\n" +
            "   \"reminders\": {\n" +
            "    \"useDefault\": true\n" +
            "   }\n" +
            "  }\n" +
            " ]\n" +
            "}";
}
