import seaborn as sns
import matplotlib.pyplot as plt
import pandas as pd

df=pd.read_csv('mem_new.csv')
sns.set(font_scale=3)
sns.boxplot(data=df,x='App', y='Mem_use', hue='Framework',showfliers=False)
plt.xlabel('Apps', fontsize=35)
plt.ylabel('Memory Usage',fontsize=35)
plt.show()
