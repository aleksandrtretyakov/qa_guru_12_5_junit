package guru.qa.domain;

public enum HeaderItem {
    OzonForBusiness("Ozon для бизнеса"), MobileApp("Мобильное приложение"),
    SellOnOzon("Продавайте на Ozon"), EarnWithOzon("Зарабатывай с Ozon"),
    GiftCertificates("Подарочные сертификаты"), Help("Помощь"),
    DistributionPoints("Пункты выдачи");

    public final String ruName;

    HeaderItem(String ruName) {
        this.ruName = ruName;
    }
}

