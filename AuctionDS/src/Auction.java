import java.util.*;

public class Auction {
    private int currentMinBid;
    private int currentMaxBid = -1; // Tracks the highest valid bid
    private Map<Integer, Set<String>> bidsMap = new HashMap<>();

    public Auction(int initialMinBid) {
        this.currentMinBid = initialMinBid;
    }

    public void placeBid(String bidderId, int bidAmount) {
        if (bidAmount < currentMinBid) return;

        // make max bid the same as highest bid amount
        if (bidAmount > currentMaxBid) {
            currentMaxBid = bidAmount;
        }

        // if bid is higher than the current max bid add to map
        bidsMap.computeIfAbsent(bidAmount, k -> new HashSet<>()).add(bidderId);
        // LinkedHashSet
        //bidsMap.computeIfAbsent(bidAmount, k -> new LinkedHashSet<>()).add(bidderId);
    }

    // if using LinkedHashSet
//    public String closeAuction() {
//        if (currentMaxBid == -1) {
//            currentMinBid++;
//            return null;
//        }
//        return bidsMap.get(currentMaxBid).iterator().next();
//    }

    public String closeAuction() {
        if (currentMaxBid == -1) {
            currentMinBid++;
            return null;
        }

        Set<String> winners = bidsMap.get(currentMaxBid);
        if (winners.size() == 1) {
            return winners.iterator().next();
        } else {
            // restart auction if no winner and add 1
            currentMinBid = currentMaxBid + 1;
            currentMaxBid = -1;
            bidsMap.clear();
            return null;
        }
    }

    public int getCurrentMinBid() {
        return currentMinBid;
    }
}
