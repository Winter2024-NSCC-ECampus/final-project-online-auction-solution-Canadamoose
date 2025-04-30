public class Main {
    public static void main(String[] args) {
        // min bid
        Auction auction = new Auction(100);

        // bids
        auction.placeBid("Alice", 150);
        auction.placeBid("Bob", 150);
        auction.placeBid("Charlie", 200);
        auction.placeBid("Dave", 200);

        String winner = auction.closeAuction();
        if (winner != null) {
            System.out.println("Winner: " + winner);
        } else {
            System.out.println("Auction restarted. New min bid: $" + auction.getCurrentMinBid());
        }

        // bids after restart
        auction.placeBid("Alice", 340);
        auction.placeBid("Bob", 204);
        auction.placeBid("Charlie", 200);
        auction.placeBid("Dave", 300);

        winner = auction.closeAuction();
        if (winner != null) {
            System.out.println("Winner: " + winner);
        } else {
            System.out.println("Auction restarted. New min bid: $" + auction.getCurrentMinBid());
        }
    }
}
