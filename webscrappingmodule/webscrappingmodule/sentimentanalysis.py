from nltk.sentiment.vader import SentimentIntensityAnalyzer as SIA
import pandas as pd
from . import preprocessdata as ppd

sia = SIA()
results = []

positive_sentiments_count = 0
negative_sentiments_count = 0
neutral_sentiments_count = 0


def perform_sentimental_analysis():
    global positive_sentiments_count, negative_sentiments_count, neutral_sentiments_count

    tesla_processed_content_df = pd.read_csv('tesla_processed_content.csv')
    # compute compound polarity scores
    for text in tesla_processed_content_df.processed_content:
        pol_score = sia.polarity_scores(text)
        pol_score['text'] = text
        results.append(pol_score)

    df = pd.DataFrame.from_records(results)
    df.head()
    df['score'] = 0
    df.loc[df['compound'] > 0, 'score'] = 1
    df.loc[df['compound'] < 0, 'score'] = -1
    df.head()
    df2 = df[['text', 'score', 'compound']]
    df2.to_csv('tesla_sentiment_analysis.csv', mode='a', encoding='utf-8', index=False)

    df_positive = df[df.score == 1]
    positive = df_positive.score.count()
    positive_sentiments_count = positive_sentiments_count + positive

    df_neutral = df[df.score == 0]
    neutral = df_neutral.score.count()
    neutral_sentiments_count = neutral_sentiments_count + neutral

    df_negative = df[df.score == -1]
    negative = df_negative.score.count()
    negative_sentiments_count = negative_sentiments_count + negative

    print("positive_sentiments_count: ", positive_sentiments_count)
    print("neutral_sentiments_count: ", neutral_sentiments_count)
    print("negative_sentiments_count: ", negative_sentiments_count)


if __name__ == '__main__':
    print('---Pre process tesla content---')
    ppd.clean_content_and_save_to_csv()
    print('---Perform sentiment analysis---')
    perform_sentimental_analysis()
