class Tweet {
    int time;
    int tweetID;
    Tweet() {
        time = 0;
        tweetID = 0;
    }
}

class Twitter {
    HashMap<Integer, Set<Integer>> follow;
    HashMap<Integer, ArrayList<Tweet>> tweet;
    int time = 0;

    public Twitter() {
        follow = new HashMap<>();
        tweet = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!tweet.containsKey(userId)) {
            tweet.put(userId, new ArrayList<>());
        }
        Tweet t = new Tweet();
        t.time = time++;
        t.tweetID = tweetId;
        tweet.get(userId).add(t);
    }

    public List<Integer> getNewsFeed(int userId) {
        ArrayList<Integer> feed = new ArrayList<>();
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);

        if (tweet.containsKey(userId)) {
            for (Tweet it : tweet.get(userId)) {
                pq.add(it);
            }
        }

        if (follow.containsKey(userId)) {
            for (int followeeId : follow.get(userId)) {
                if (tweet.containsKey(followeeId)) {
                    for (Tweet it : tweet.get(followeeId)) {
                        pq.add(it);
                    }
                }
            }
        }

        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            feed.add(pq.poll().tweetID);
            count++;
        }
        return feed;
    }

    public void follow(int followerId, int followeeId) {
        if (!follow.containsKey(followerId)) {
            follow.put(followerId, new HashSet<>());
        }
        follow.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (follow.containsKey(followerId)) {
            follow.get(followerId).remove(followeeId);
        }
    }
}
