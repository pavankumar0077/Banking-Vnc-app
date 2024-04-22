import seaborn as sns
import matplotlib.pyplot as plt
import pandas as pd

df=pd.read_csv('cpu_new.csv')
sns.set(font_scale=3)
sns.boxplot(data=df,x='App_Name', y='CPU_Use', hue='Framework',showfliers=False)
plt.xlabel('Apps', fontsize=35)
plt.ylabel('CPU Usage',fontsize=35)
plt.show()
