package me.hyperperform.event;

/**
 * Created by rohan on 2016/07/06.
 */
public class MockEvent
{
    public static String travisEvent = "{" +
        "  \"id\": 1," +
        "  \"number\": \"1\"," +
        "  \"status\": null," +
        "  \"started_at\": null," +
        "  \"finished_at\": null," +
        "  \"status_message\": \"Passed\"," +
        "  \"commit\": \"62aae5f70ceee39123ef\"," +
        "  \"branch\": \"master\"," +
        "  \"message\": \"the commit message\"," +
        "  \"compare_url\": \"https://github.com/svenfuchs/minimal/compare/master...develop\"," +
        "  \"committed_at\": \"2011-11-11T11: 11: 11Z\"," +
        "  \"committer_name\": \"Sven Fuchs\"," +
        "  \"committer_email\": \"svenfuchs@artweb-design.de\"," +
        "  \"author_name\": \"Sven Fuchs\"," +
        "  \"author_email\": \"svenfuchs@artweb-design.de\"," +
        "  \"type\": \"push\"," +
        "  \"build_url\": \"https://travis-ci.org/svenfuchs/minimal/builds/1\"," +
        "  \"repository\": {" +
        "    \"id\": 1," +
        "    \"name\": \"minimal\"," +
        "    \"owner_name\": \"svenfuchs\"," +
        "    \"url\": \"http://github.com/svenfuchs/minimal\"" +
        "   }," +
        "  \"config\": {" +
        "    \"notifications\": {" +
        "      \"webhooks\": [\"http://evome.fr/notifications\", \"http://example.com/\"]" +
        "    }" +
        "  }," +
        "  \"matrix\": [" +
        "    {" +
        "      \"id\": 2," +
        "      \"repository_id\": 1," +
        "      \"number\": \"1.1\"," +
        "      \"state\": \"created\"," +
        "      \"started_at\": null," +
        "      \"finished_at\": null," +
        "      \"config\": {" +
        "        \"notifications\": {" +
        "          \"webhooks\": [\"http://evome.fr/notifications\", \"http://example.com/\"]" +
        "        }" +
        "      }," +
        "      \"status\": null," +
        "      \"log\": \"\"," +
        "      \"result\": null," +
        "      \"parent_id\": 1," +
        "      \"commit\": \"62aae5f70ceee39123ef\"," +
        "      \"branch\": \"master\"," +
        "      \"message\": \"the commit message\"," +
        "      \"committed_at\": \"2011-11-11T11: 11: 11Z\"," +
        "      \"committer_name\": \"Sven Fuchs\"," +
        "      \"committer_email\": \"svenfuchs@artweb-design.de\"," +
        "      \"author_name\": \"Sven Fuchs\"," +
        "      \"author_email\": \"svenfuchs@artweb-design.de\"," +
        "      \"compare_url\": \"https://github.com/svenfuchs/minimal/compare/master...develop\"" +
        "    }" +
        "  ]" +
        "}";

    public static String alternativeGitPush = "{" +
"        \"ref\": \"refs/heads/master\"," +
"        \"before\": \"afc7afa4d0703978a7941d6135a141aa06fe40d9\"," +
"        \"after\": \"054d091c30d6744723e25534f5c9b5564908d730\"," +
"        \"created\": false," +
"        \"deleted\": false," +
"        \"forced\": false," +
"        \"base_ref\": null," +
"        \"compare\": \"https://github.com/RohanChhipa/COS332/compare/afc7afa4d070...054d091c30d6\"," +
"        \"commits\": [" +
"          {" +
"            \"id\": \"054d091c30d6744723e25534f5c9b5564908d730\"," +
"            \"tree_id\": \"48c110763039a2894181829a4dea730e10dd3cf2\"," +
"            \"distinct\": true," +
"            \"message\": \"deletedfile\"," +
"            \"timestamp\": \"2016-07-28T22:42:44+02:00\"," +
"            \"url\": \"https://github.com/RohanChhipa/COS332/commit/054d091c30d6744723e25534f5c9b5564908d730\"," +
"            \"author\": {" +
"              \"name\": \"rohanchhipa\"," +
"              \"email\": \"rohan.chhipa@live.com\"," +
"              \"username\": \"RohanChhipa\"" +
"            }," +
"            \"committer\": {" +
"              \"name\": \"rohanchhipa\"," +
"              \"email\": \"rohan.chhipa@live.com\"," +
"              \"username\": \"RohanChhipa\"" +
"            }," +
"            \"added\": [" +
"" +
"            ]," +
"            \"removed\": [" +
"              \"testFile\"" +
"            ]," +
"            \"modified\": [" +
"" +
"            ]" +
"          }" +
"        ]," +
"        \"head_commit\": {" +
"          \"id\": \"054d091c30d6744723e25534f5c9b5564908d730\"," +
"          \"tree_id\": \"48c110763039a2894181829a4dea730e10dd3cf2\"," +
"          \"distinct\": true," +
"          \"message\": \"deletedfile\"," +
"          \"timestamp\": \"2016-07-28T22:42:44+02:00\"," +
"          \"url\": \"https://github.com/RohanChhipa/COS332/commit/054d091c30d6744723e25534f5c9b5564908d730\"," +
"          \"author\": {" +
"            \"name\": \"rohanchhipa\"," +
"            \"email\": \"rohan.chhipa@live.com\"," +
"            \"username\": \"RohanChhipa\"" +
"          }," +
"          \"committer\": {" +
"            \"name\": \"rohanchhipa\"," +
"            \"email\": \"rohan.chhipa@live.com\"," +
"            \"username\": \"RohanChhipa\"" +
"          }," +
"          \"added\": [" +
"" +
"          ]," +
"          \"removed\": [" +
"            \"testFile\"" +
"          ]," +
"          \"modified\": [" +
"" +
"          ]" +
"        }," +
"        \"repository\": {" +
"          \"id\": 50978789," +
"          \"name\": \"COS332\"," +
"          \"full_name\": \"RohanChhipa/COS332\"," +
"          \"owner\": {" +
"            \"name\": \"RohanChhipa\"," +
"            \"email\": \"u14188377@tuks.co.za\"" +
"          }," +
"          \"private\": true," +
"          \"html_url\": \"https://github.com/RohanChhipa/COS332\"," +
"          \"description\": \"For COS332 practicals\"," +
"          \"fork\": false," +
"          \"url\": \"https://github.com/RohanChhipa/COS332\"," +
"          \"forks_url\": \"https://api.github.com/repos/RohanChhipa/COS332/forks\"," +
"          \"keys_url\": \"https://api.github.com/repos/RohanChhipa/COS332/keys{/key_id}\"," +
"          \"collaborators_url\": \"https://api.github.com/repos/RohanChhipa/COS332/collaborators{/collaborator}\"," +
"          \"teams_url\": \"https://api.github.com/repos/RohanChhipa/COS332/teams\"," +
"          \"hooks_url\": \"https://api.github.com/repos/RohanChhipa/COS332/hooks\"," +
"          \"issue_events_url\": \"https://api.github.com/repos/RohanChhipa/COS332/issues/events{/number}\"," +
"          \"events_url\": \"https://api.github.com/repos/RohanChhipa/COS332/events\"," +
"          \"assignees_url\": \"https://api.github.com/repos/RohanChhipa/COS332/assignees{/user}\"," +
"          \"branches_url\": \"https://api.github.com/repos/RohanChhipa/COS332/branches{/branch}\"," +
"          \"tags_url\": \"https://api.github.com/repos/RohanChhipa/COS332/tags\"," +
"          \"blobs_url\": \"https://api.github.com/repos/RohanChhipa/COS332/git/blobs{/sha}\"," +
"          \"git_tags_url\": \"https://api.github.com/repos/RohanChhipa/COS332/git/tags{/sha}\"," +
"          \"git_refs_url\": \"https://api.github.com/repos/RohanChhipa/COS332/git/refs{/sha}\"," +
"          \"trees_url\": \"https://api.github.com/repos/RohanChhipa/COS332/git/trees{/sha}\"," +
"          \"statuses_url\": \"https://api.github.com/repos/RohanChhipa/COS332/statuses/{sha}\"," +
"          \"languages_url\": \"https://api.github.com/repos/RohanChhipa/COS332/languages\"," +
"          \"stargazers_url\": \"https://api.github.com/repos/RohanChhipa/COS332/stargazers\"," +
"          \"contributors_url\": \"https://api.github.com/repos/RohanChhipa/COS332/contributors\"," +
"          \"subscribers_url\": \"https://api.github.com/repos/RohanChhipa/COS332/subscribers\"," +
"          \"subscription_url\": \"https://api.github.com/repos/RohanChhipa/COS332/subscription\"," +
"          \"commits_url\": \"https://api.github.com/repos/RohanChhipa/COS332/commits{/sha}\"," +
"          \"git_commits_url\": \"https://api.github.com/repos/RohanChhipa/COS332/git/commits{/sha}\"," +
"          \"comments_url\": \"https://api.github.com/repos/RohanChhipa/COS332/comments{/number}\"," +
"          \"issue_comment_url\": \"https://api.github.com/repos/RohanChhipa/COS332/issues/comments{/number}\"," +
"          \"contents_url\": \"https://api.github.com/repos/RohanChhipa/COS332/contents/{+path}\"," +
"          \"compare_url\": \"https://api.github.com/repos/RohanChhipa/COS332/compare/{base}...{head}\"," +
"          \"merges_url\": \"https://api.github.com/repos/RohanChhipa/COS332/merges\"," +
"          \"archive_url\": \"https://api.github.com/repos/RohanChhipa/COS332/{archive_format}{/ref}\"," +
"          \"downloads_url\": \"https://api.github.com/repos/RohanChhipa/COS332/downloads\"," +
"          \"issues_url\": \"https://api.github.com/repos/RohanChhipa/COS332/issues{/number}\"," +
"          \"pulls_url\": \"https://api.github.com/repos/RohanChhipa/COS332/pulls{/number}\"," +
"          \"milestones_url\": \"https://api.github.com/repos/RohanChhipa/COS332/milestones{/number}\"," +
"          \"notifications_url\": \"https://api.github.com/repos/RohanChhipa/COS332/notifications{?since,all,participating}\"," +
"          \"labels_url\": \"https://api.github.com/repos/RohanChhipa/COS332/labels{/name}\"," +
"          \"releases_url\": \"https://api.github.com/repos/RohanChhipa/COS332/releases{/id}\"," +
"          \"deployments_url\": \"https://api.github.com/repos/RohanChhipa/COS332/deployments\"," +
"          \"created_at\": 1454480387," +
"          \"updated_at\": \"2016-02-03T08:49:53Z\"," +
"          \"pushed_at\": 1469738587," +
"          \"git_url\": \"git://github.com/RohanChhipa/COS332.git\"," +
"          \"ssh_url\": \"git@github.com:RohanChhipa/COS332.git\"," +
"          \"clone_url\": \"https://github.com/RohanChhipa/COS332.git\"," +
"          \"svn_url\": \"https://github.com/RohanChhipa/COS332\"," +
"          \"homepage\": null," +
"          \"size\": 46," +
"          \"stargazers_count\": 2," +
"          \"watchers_count\": 2," +
"          \"language\": \"Java\"," +
"          \"has_issues\": true," +
"          \"has_downloads\": true," +
"          \"has_wiki\": true," +
"          \"has_pages\": false," +
"          \"forks_count\": 0," +
"          \"mirror_url\": null," +
"          \"open_issues_count\": 0," +
"          \"forks\": 0," +
"          \"open_issues\": 0," +
"          \"watchers\": 2," +
"          \"default_branch\": \"master\"," +
"          \"stargazers\": 2," +
"          \"master_branch\": \"master\"" +
"        }," +
"        \"pusher\": {" +
"          \"name\": \"RohanChhipa\"," +
"          \"email\": \"u14188377@tuks.co.za\"" +
"        }," +
"        \"sender\": {" +
"          \"login\": \"RohanChhipa\"," +
"          \"id\": 11084914," +
"          \"avatar_url\": \"https://avatars.githubusercontent.com/u/11084914?v=3\"," +
"          \"gravatar_id\": \"\"," +
"          \"url\": \"https://api.github.com/users/RohanChhipa\"," +
"          \"html_url\": \"https://github.com/RohanChhipa\"," +
"          \"followers_url\": \"https://api.github.com/users/RohanChhipa/followers\"," +
"          \"following_url\": \"https://api.github.com/users/RohanChhipa/following{/other_user}\"," +
"          \"gists_url\": \"https://api.github.com/users/RohanChhipa/gists{/gist_id}\"," +
"          \"starred_url\": \"https://api.github.com/users/RohanChhipa/starred{/owner}{/repo}\"," +
"          \"subscriptions_url\": \"https://api.github.com/users/RohanChhipa/subscriptions\"," +
"          \"organizations_url\": \"https://api.github.com/users/RohanChhipa/orgs\"," +
"          \"repos_url\": \"https://api.github.com/users/RohanChhipa/repos\"," +
"          \"events_url\": \"https://api.github.com/users/RohanChhipa/events{/privacy}\"," +
"          \"received_events_url\": \"https://api.github.com/users/RohanChhipa/received_events\"," +
"          \"type\": \"User\"," +
"          \"site_admin\": false" +
"        }" +
"      }";

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

    public static String calendarEvents = "{\n" +
            " \"kind\": \"calendar#events\",\n" +
            " \"etag\": \"\\\"p338avpsepiccs0g\\\"\",\n" +
            " \"summary\": \"Test Calendar\",\n" +
            " \"description\": \"\",\n" +
            " \"updated\": \"2016-07-29T11:43:20.578Z\",\n" +
            " \"timeZone\": \"Africa/Johannesburg\",\n" +
            " \"accessRole\": \"owner\",\n" +
            " \"defaultReminders\": [\n" +
            " ],\n" +
            " \"nextSyncToken\": \"CNCv547MmM4CENCv547MmM4CGAU=\",\n" +
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
            "  },\n" +
            "  {\n" +
            "\n" +
            "   \"kind\": \"calendar#event\",\n" +
            "   \"etag\": \"\\\"2938782291040000\\\"\",\n" +
            "   \"id\": \"sk0t2sj8bgaonf67uo00maib74\",\n" +
            "   \"status\": \"confirmed\",\n" +
            "   \"htmlLink\": \"https://www.google.com/calendar/event?eid=c2swdDJzajhiZ2FvbmY2N3VvMDBtYWliNzQgaGszNDg3Z2Q3aDU3b2g5ZzcxaGU5dGZqczBAZw\",\n" +
            "   \"created\": \"2016-07-23T13:21:08.000Z\",\n" +
            "   \"updated\": \"2016-07-24T20:12:25.520Z\",\n" +
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
            "     \"responseStatus\": \"declined\"\n" +
            "    },\n" +
            "    {\n" +
            "     \"email\": \"gordonjdgo@gmail.com\",\n" +
            "     \"responseStatus\": \"declined\"\n" +
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
            "   \"etag\": \"\\\"2939585201004000\\\"\",\n" +
            "   \"id\": \"ph3dsvkc6sepvoliq3p2g00rmk\",\n" +
            "   \"status\": \"confirmed\",\n" +
            "   \"htmlLink\": \"https://www.google.com/calendar/event?eid=cGgzZHN2a2M2c2Vwdm9saXEzcDJnMDBybWsgaGszNDg3Z2Q3aDU3b2g5ZzcxaGU5dGZqczBAZw\",\n" +
            "   \"created\": \"2016-07-25T08:07:52.000Z\",\n" +
            "   \"updated\": \"2016-07-29T11:43:20.502Z\",\n" +
            "   \"summary\": \"hyper-perform@RepoName - Non updated test\",\n" +
            "   \"description\": \"Finish Calendar Listener\",\n" +
            "   \"creator\": {\n" +
            "    \"email\": \"hyperperformteam@gmail.com\"\n" +
            "   },\n" +
            "   \"organizer\": {\n" +
            "    \"email\": \"hk3487gd7h57oh9g71he9tfjs0@group.calendar.google.com\",\n" +
            "    \"displayName\": \"Test Calendar\",\n" +
            "    \"self\": true\n" +
            "   },\n" +
            "   \"start\": {\n" +
            "    \"date\": \"2016-07-25\"\n" +
            "   },\n" +
            "   \"end\": {\n" +
            "    \"date\": \"2016-07-26\"\n" +
            "   },\n" +
            "   \"transparency\": \"transparent\",\n" +
            "   \"iCalUID\": \"ph3dsvkc6sepvoliq3p2g00rmk@google.com\",\n" +
            "   \"sequence\": 0,\n" +
            "   \"attendees\": [\n" +
            "    {\n" +
            "     \"email\": \"u14405025@tuks.co.za\",\n" +
            "     \"responseStatus\": \"accepted\"\n" +
            "    },\n" +
            "    {\n" +
            "     \"email\": \"gordz.gordon@gmail.com\",\n" +
            "     \"displayName\": \"Jason Gordon\",\n" +
            "     \"responseStatus\": \"accepted\"\n" +
            "    },\n" +
            "    {\n" +
            "     \"email\": \"gordonjdgo@gmail.com\",\n" +
            "     \"responseStatus\": \"accepted\"\n" +
            "    }\n" +
            "   ],\n" +
            "   \"reminders\": {\n" +
            "    \"useDefault\": true\n" +
            "   }\n" +
            "  }\n" +
            " ]\n" +
            "}";


}
