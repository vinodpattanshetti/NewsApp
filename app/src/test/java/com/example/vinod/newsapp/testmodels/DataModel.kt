package com.example.vinod.newsapp.testmodels

import com.example.vinod.newsapp.model.Article
import com.example.vinod.newsapp.model.News
import com.example.vinod.newsapp.model.Source

fun getNewsSampleDataModel() = News(
  id = 1,
  status = "ok",
  totalResults = 131,
  articles = getListOfArticlesModel(),
  code = "",
  message = "",
  isError = false
)

fun getListOfArticlesModel(): ArrayList<Article> {
  val mList = ArrayList<Article>()
  val article1 = Article().apply {
    val testSource = Source().apply {
      id = "100"
      name = "Seekingalpha.com"
    }
    source = testSource
    author = "SA Editor Pranav Ghumatkar"
    title = "On the hour"
    description =
      "Dow +0.09%.10-yr +0.15%.Euro -0.02% vs. dollar.Crude +0.90% to \$58.53Gold -0.15% to \$1,461.55.Bitcoin -1.60% to \$7,104.2"
    url = "https://seekingalpha.com/news/3522113-hour"
    urlToImage =
      "https://static3.seekingalpha.com/assets/og_image_192-59bfd51c9fe6af025b2f9f96c807e46f8e2f06c5ae787b15bf1423e6c676d4db.png"
    publishedAt = "2019-11-26T15:00:51Z"
    content =
      "Dow +0.09%.\\r\\n10-yr +0.15%.\\r\\nEuro -0.02% vs. dollar.\\r\\nCrude +0.90% to \$58.53\\r\\nGold -0.15% to \$1,461.55.\\r\\nBitcoin -1.60% to \$7,104.2"
  }

  mList.add(article1)
  val article2 = Article().apply {
    val testSource = Source().apply {
      id = "101"
      name = "Tuexperto.com"
    }
    source = testSource
    author = "Juan Carlos Broncano"
    title = "7 alternativas al Bitcoin para invertir que están creciendo en 2019"
    description =
      "Conoce las mejores alternativas al Bitcoin para invertir durante 2019 y 2020 que están experimento un aumento similar a esta última."
    url = "https://www.tuexperto.com/2019/11/26/alternativas-bitcoin-invertir-estan-creciendo-2019/"
    urlToImage = "https://www.tuexperto.com/wp-content/uploads/2019/11/comprar-bitcoin.jpg"
    publishedAt = "2019-11-26T15:00:40Z"
    content =
      "Tras el incesante descenso del valor del Bitcoin durante las últimas semanas, la criptomoneda más conocida de la última década ha vuelto a remontar en la bolsa de valores. Junto con esta, existen una serie de alternativas al Bitcoin cuyo valor se ha visto inc… [+5949 chars]"
  }

  mList.add(article2)
  val article3 = Article().apply {
    val testSource = Source().apply {
      id = "102"
      name = "Dzone.com"
    }
    source = testSource
    author = "Cate Lawrence"
    title = "How the Tech Community Can Help in Response to Iran's Internet Shutdown"
    description =
      "Learn more about how the tech community can be of assistance during Iran's Internet shutdown. Over the last few weeks, the Internet in Iran has been shut down by the Iran government following protests over a significant increase in fuel prices, affecting over…"
    url =
      "https://dzone.com/articles/how-the-tech-community-can-help-in-response-to-ira?utm_medium=feed&utm_source=feedpress.me&utm_campaign=Feed%3A+dzone%2Fiot"
    urlToImage = "https://dz2cdn2.dzone.com/storage/article-thumb/12769737-thumb.jpg"
    publishedAt = "2019-11-26T14:59:11Z"
    content =
      "Learn more about how the tech community can be of assistance during Iran's Internet shutdown.\\r\\nOver the last few weeks, the Internet in Iran has been shut down by the Iran government following protests over a significant increase in fuel prices, affecting ove… [+7526 chars]"
  }
  mList.add(article3)
  val article4 = Article().apply {
    val testSource = Source().apply {
      id = "103"
      name = "Itsecuritynews.info"
    }
    source = testSource
    author = "www.ITSecurityNews.info"
    title = "Finland Municipalities and Government Agencies Prepare for Possible Cyberattack"
    description =
      "Finland is adapting to protect itself from a secret criminal organization warning to attack cyber-security if the country fails to pay Bitcoins as the ransom money. “Around two hundred Finland government bodies and districts participated in the preparation."
    url =
      "https://www.itsecuritynews.info/finland-municipalities-and-government-agencies-prepare-for-possible-cyberattack/"
    urlToImage =
      "https://www.itsecuritynews.info/wp-content/plugins/all-in-one-seo-pack/images/default-user-image.png"
    publishedAt = "2019-11-26T14:41:00Z"
    content =
      "Finland is adapting to protect itself from a secret criminal organization warning to attack cyber-security if the country fails to pay Bitcoins as the ransom money. “Around two hundred Finland government bodies and districts participated in the preparation. T… [+2061 chars]"
  }

  mList.add(article4)
  val article5 = Article().apply {
    val testSource = Source().apply {
      id = "104"
      name = "Pypi.org"
    }
    source = testSource
    author = "ing-theme-matplotlib added to PyPI"
    title = "ING styles for common plotting libraries"
    description =
      "Dow +0.09%.10-yr +0.15%.Euro -0.02% vs. dollar.Crude +0.90% to \$58.53Gold -0.15% to \$1,461.55.Bitcoin -1.60% to \$7,104.2"
    url = "https://seekingalpha.com/news/3522113-hour"
    urlToImage =
      "https://static3.seekingalpha.com/assets/og_image_192-59bfd51c9fe6af025b2f9f96c807e46f8e2f06c5ae787b15bf1423e6c676d4db.png"
    publishedAt = "2019-11-26T15:00:51Z"
    content =
      "Dow +0.09%.\\r\\n10-yr +0.15%.\\r\\nEuro -0.02% vs. dollar.\\r\\nCrude +0.90% to \$58.53\\r\\nGold -0.15% to \$1,461.55.\\r\\nBitcoin -1.60% to \$7,104.2"
  }
  mList.add(article5)
  val article6 = Article().apply {
    val testSource = Source().apply {
      id = "100"
      name = "Bbc.com"
    }
    source = testSource
    author = "https://www.facebook.com/bbcnews"
    title =
      "'Rainha da criptomoeda': A mulher que enganou milhares de investidores e depois desapareceu"
    description =
      "Dow +0.09%.10-yr +0.15%.Euro -0.02% vs. dollar.Crude +0.90% to \$58.53Gold -0.15% to \$1,461.55.Bitcoin -1.60% to \$7,104.2"
    url = "https://seekingalpha.com/news/3522113-hour"
    urlToImage =
      "https://static3.seekingalpha.com/assets/og_image_192-59bfd51c9fe6af025b2f9f96c807e46f8e2f06c5ae787b15bf1423e6c676d4db.png"
    publishedAt = "2019-11-26T15:00:51Z"
    content =
      "Dow +0.09%.\\r\\n10-yr +0.15%.\\r\\nEuro -0.02% vs. dollar.\\r\\nCrude +0.90% to \$58.53\\r\\nGold -0.15% to \$1,461.55.\\r\\nBitcoin -1.60% to \$7,104.2"
  }

  mList.add(article6)
  val article7 = Article().apply {
    val testSource = Source().apply {
      id = "105"
      name = "Ehackingnews.com"
    }
    source = testSource
    author = "Samarth Mishra"
    title = "Finland Municipalities and Government Agencies Prepare for Possible Cyberattack"
    description =
      "Finland is adapting to protect itself from a secret criminal organization warning to attack cyber-security if the country fails to pay Bitcoins as the ransom money."
    url = "https://seekingalpha.com/news/3522113-hour"
    urlToImage =
      "https://static3.seekingalpha.com/assets/og_image_192-59bfd51c9fe6af025b2f9f96c807e46f8e2f06c5ae787b15bf1423e6c676d4db.png"
    publishedAt = "2019-11-26T15:00:51Z"
    content =
      "Dow +0.09%.\\r\\n10-yr +0.15%.\\r\\nEuro -0.02% vs. dollar.\\r\\nCrude +0.90% to \$58.53\\r\\nGold -0.15% to \$1,461.55.\\r\\nBitcoin -1.60% to \$7,104.2"
  }

  mList.add(article7)
  val article8 = Article().apply {
    val testSource = Source().apply {
      id = "106"
      name = "Ekonomika.sme.sk"
    }
    source = testSource
    author = "TASR"
    title = "Európania minuli v roku 2017 na marihuanu vyše jedenásť miliárd eur"
    description =
      "Celkový trh s narkotikami v EÚ dosiahol v roku 2017 hodnotu najmenej 30 miliárd eur."
    url = "https://seekingalpha.com/news/3522113-hour"
    urlToImage =
      "https://static3.seekingalpha.com/assets/og_image_192-59bfd51c9fe6af025b2f9f96c807e46f8e2f06c5ae787b15bf1423e6c676d4db.png"
    publishedAt = "2019-11-26T15:00:51Z"
    content =
      "Dow +0.09%.\\r\\n10-yr +0.15%.\\r\\nEuro -0.02% vs. dollar.\\r\\nCrude +0.90% to \$58.53\\r\\nGold -0.15% to \$1,461.55.\\r\\nBitcoin -1.60% to \$7,104.2"
  }

  mList.add(article8)
  val article9 = Article().apply {
    val testSource = Source().apply {
      id = "107"
      name = "Dzone.com"
    }
    source = testSource
    author = "Chris Ward"
    title = "IOST — The Decentralized Internet of Services"
    description =
      "Find out more about IOST, and the decentralized internet of services. You may also like: The Internet of Things: Why Decentralization Must Be the Next Step IOST is an ultra-fast, decentralized blockchain network based on the next-generation consensus algorith…"
    url = "https://seekingalpha.com/news/3522113-hour"
    urlToImage =
      "https://static3.seekingalpha.com/assets/og_image_192-59bfd51c9fe6af025b2f9f96c807e46f8e2f06c5ae787b15bf1423e6c676d4db.png"
    publishedAt = "2019-11-26T15:00:51Z"
    content =
      "Dow +0.09%.\\r\\n10-yr +0.15%.\\r\\nEuro -0.02% vs. dollar.\\r\\nCrude +0.90% to \$58.53\\r\\nGold -0.15% to \$1,461.55.\\r\\nBitcoin -1.60% to \$7,104.2"
  }
  mList.add(article9)
  val article10 = Article().apply {
    val testSource = Source().apply {
      id = "108"
      name = "Dzone.com"
    }
    source = testSource
    author = "Chris Ward"
    title = "IOST — The Decentralized Internet of Services"
    description =
      "Find out more about IOST, and the decentralized internet of services. You may also like: The Internet of Things: Why Decentralization Must Be the Next Step IOST is an ultra-fast, decentralized blockchain network based on the next-generation consensus algorith…"
    url = "https://seekingalpha.com/news/3522113-hour"
    urlToImage =
      "https://static3.seekingalpha.com/assets/og_image_192-59bfd51c9fe6af025b2f9f96c807e46f8e2f06c5ae787b15bf1423e6c676d4db.png"
    publishedAt = "2019-11-26T15:00:51Z"
    content =
      "Dow +0.09%.\\r\\n10-yr +0.15%.\\r\\nEuro -0.02% vs. dollar.\\r\\nCrude +0.90% to \$58.53\\r\\nGold -0.15% to \$1,461.55.\\r\\nBitcoin -1.60% to \$7,104.2"
  }


  mList.add(article10)
  return mList
}

fun getNewsSampleDataModelForFailure() = News(
  id = 0,
  status = "error",
  totalResults = 0,
  articles = null,
  code = "parameterInvalid",
  message = "You are trying to request results too far in the past. Your plan permits you to request articles as far back as 2019-10-25, but you have requested 2019-10-24. To extend this please upgrade to a paid plan.",
  isError = true
)

fun getArticleSize() = News(
  id = 1,
  status = "ok",
  totalResults = 131,
  articles = getListOfArticlesModel(),
  code = "",
  message = "",
  isError = false
)

fun getArticleListSize() = 20