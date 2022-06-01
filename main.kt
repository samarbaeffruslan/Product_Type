fun main() {
    CreditProduct("123").apply {
        creditApproved(isWorked = false)
    }

    InvestProduct("213").apply {
        showSharePrice()
        buyNumberOfShares(numberOfShares = 10)
    }

    MortgageProduct("2131").apply {
        setupMortgageInterest(5)
    }



}

/**
 * Product - интерфейс, который содержит свойства
 * общие для всех реализаций Product. Был выбран
 * interface, а не абстрактный класс, потому что
 *
 **/
interface Product {
    /**
     * @param productHolderName - постоянный параметр
     * для любой реализации Product
     */
    val productHolderName: String
        get() = "Имя владельца продукта Руслан"

    /**
     * @param accountNumber - номер аккаунта пользователя продукта.
     * Свойство является по-умолчанию абстрактным, потому что
     * находится внутри интерфейса.
     * */
    val accountNumber: String
    /**
     * @param numberProduct - номер продукта. Каждый продукт иметь свой номер
     * */
    val numberProduct: Int
}

/**
 * Ипотечный продукт, реализующий интерфейс Product
 * */
class MortgageProduct(
    /** @param accountNumber - обязательный параметр для создания экземпляра MortgageProduct.
     * Номер аккаунта - это уникальный номер, который принадлежит только этому клиенту этого
     * продукта.
     * */
    override val accountNumber: String
) : Product {
    /** @param accountNumber - номер продукта
     * */
    override val numberProduct: Int = 1

    /** Одобрение ипотеки в зависимости от количества детей. Функционал характерен только для этого типа продукта.
     * @param countChild - количество детей.
     * */
    fun setupMortgageInterest(countChild: Int) {
        if (countChild > 3) {
            println("Ипотека для клиента №$accountNumber составив 4% годовых")
        } else {
            println("Ипотека для клиента №$accountNumber составив 6% годовых")
        }
    }

}

/**
 * Инвестиционный продукт, реализующий интерфейс Product
 * */
class InvestProduct(
    /** @param accountNumber - обязательный параметр для создания экземпляра InvestProduct.
     * Номер аккаунта - это уникальный номер, который принадлежит только этому клиенту этого
     * продукта.
     * */
    override val accountNumber: String,
) : Product {

    /** @param accountNumber - номер продукта
     * */
    override val numberProduct: Int = 2

    /**
     * @param sharePrice - текущая стоимость акции на бирже
     * */
    private val sharePrice: Float = kotlin.random.Random.nextFloat()

    /**
     * покупка определенного числа акций
     * @param numberOfShares - количество акций для покупки
     * */
    fun buyNumberOfShares(numberOfShares: Int) = println("Клиент №$accountNumber купил акций на сумму ${numberOfShares * sharePrice}")

    /**
     * вывод цены акции
     * */
    fun showSharePrice() = println("Цена акции = $sharePrice")
}

/**
 * Кредитный продукт, реализующий интерфейс Product
 * */
class CreditProduct(
    /** @param accountNumber - обязательный параметр для создания экземпляра CreditProduct.
     * Номер аккаунта - это уникальный номер, который принадлежит только этому клиенту этого
     * продукта.
     * */
    override val accountNumber: String,
): Product {

    /** @param accountNumber - номер продукта
     * */
    override val numberProduct: Int = 3

    /**
     * одобрение кредита
     * @param isWorked - параметр указывающиий на то, работает человек или нет
     * */
    fun creditApproved(isWorked: Boolean){
        if(isWorked){
            println("Клиенту №$accountNumber одобрен кредит")
        } else {
            println("Клиенту №$accountNumber одобрен не кредит")
        }
    }

}
