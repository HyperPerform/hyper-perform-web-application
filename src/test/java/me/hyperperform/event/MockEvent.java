package me.hyperperform.event;

/**
 * Created by rohan on 2016/07/06.
 */
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


}
