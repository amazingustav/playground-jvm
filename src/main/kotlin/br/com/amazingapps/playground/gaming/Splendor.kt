package br.com.amazingapps.playground.gaming

/**
 * Splendor is a card-based board game where players buy cards in exchange for colored gems.
 * In this game, today, we care about two things: gems and cards.
 *
 * Players can have any number of gems of five different colors: (B)lue, (W)hite, (G)reen, (R)ed, and (Y)ellow.
 *
 * Players can exchange gems for cards. A card appears as such:
 * +----------+
 * |        G |
 * |          |
 * |          |
 * | 3W       |
 * | 2G       |
 * | 1R       |
 * +----------+
 *
 * This indicates that the card costs 3 (W)hite gems, 2 (G)reen gems, and 1 (R)ed.
 * The “G” in the upper right indicates the color of the card (this will be useful later)
 *
 * For this entire problem, we want to keep things simple by assuming that there is only one player.
 * */
class Splendor {

    fun main(args: Array<String>) {
        val defaultGems = mutableMapOf(
            'B' to 0,
            'W' to 3,
            'G' to 0,
            'R' to 0,
            'Y' to 10
        )

        val cards = mutableListOf(
            Card('G', mapOf('W' to 3, 'G' to 2, 'R' to 1)),
            Card('R', mapOf('B' to 2, 'W' to 2, 'G' to 2)),
            Card('B', mapOf('Y' to 3, 'R' to 1))
        )

        val purchasableCard = Card('G', mapOf('G' to 1))

        val hand = PlayerHand(cards, defaultGems)
        val expectedResult = purchase(purchasableCard, hand)

        println("Was card purchased? R: $expectedResult")
        println("Player's hand result: $hand")
    }

    /**
     * Given a particular card and collection of gems for a player, we add the card to the player's hand and
     * subtract the cost from the player's gems, if they are able to afford the card.
     *
     * @returns Boolean - if the player can afford the card, return true. Otherwise, return false.
     **/
    private fun purchase(card: Card, playerHand: PlayerHand): Boolean {
        val discountedCost = calculateDiscount(card, playerHand)

        if (!canPurchase(discountedCost, playerHand.gems)) return false

        discountedCost.forEach { (gem, cost) ->
            playerHand.gems[gem] = playerHand.gems.getOrDefault(gem, 0) - cost
        }

        playerHand.cards.add(card)

        return true
    }

    /**
     * We introduced the concept of discounts. The color of each card in the player's hand will be used to give
     * a discount in the respective price of that gem’s color when purchasing a new card. For example, if the player
     * has 2 white cards and 1 red card in their hand and wants to buy a card that costs 4 white gems and 1 red gem,
     * the discounted price of the card would be 2 white gems.
     **/
    private fun calculateDiscount(card: Card, playerHand: PlayerHand): Map<Char, Int> {
        return card.cost.map { (gem, cost) ->
            val amountOfCards = playerHand.cards.count { it.color == gem }

            if (amountOfCards > 0) {
                val discount = minOf(amountOfCards, cost)
                gem to maxOf(cost - discount, 0)
            } else {
                gem to cost
            }
        }.toMap()
    }

    /**
     * Given a card and a collection of gems, return true if the player can afford the card.
     * Otherwise, return false.
     **/
    private fun canPurchase(cardCost: Map<Char, Int>, gems: Map<Char, Int>): Boolean {
        return cardCost.all { (gem, cost) ->
            gems.getOrDefault(gem, 0) >= cost
        }
    }
}

data class PlayerHand(
    val cards: MutableList<Card>,
    val gems: MutableMap<Char, Int>
)

data class Card(
    val color: Char,
    val cost: Map<Char, Int>
)