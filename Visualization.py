
import matplotlib.pyplot as plt
import os

FILENAME_INDEX = 1 # Change this to read different files
FILENAME = os.path.join(os.path.dirname(__file__),"briefcase_simulation_result_"+str(FILENAME_INDEX)+".txt")

def readFile():
    fp = open(FILENAME, 'r')
    dataList = fp.readlines()
    return [float(x.split(": ")[1][:-1]) for x in dataList[:9]]

def indexMap():
    return {0: 'Total simulations',
    1: 'Total number of the contestant chooses switch',
    2: 'Total number of the contestant chooses stay',
    3:'Total number of wins',
    4: 'Number of wins chose switch',
    5:'Number of wins chose stay',
    6:'Winning rate',
    7:'Winning rate chose switch',
    8:'Winning rate chose stay'}

def barChart(dataList):
    NUM_BARS = 2 # change this if need more bars

    BAR_LOWER_BOUND = 0.2
    BAR_POSITION_SPACING = 0.2
    BAR_UPPER_BOUND = BAR_LOWER_BOUND + (NUM_BARS+1)*BAR_POSITION_SPACING

    BARS = [BAR_LOWER_BOUND + BAR_POSITION_SPACING*i for i in range(1,NUM_BARS+1)]
    plt.bar(BARS, dataList[-2:], align='center', width=BAR_POSITION_SPACING/2)
    plt.text(BARS[0], dataList[-2]+0.05, f"{(dataList[-2]*100):.1f}%")
    plt.text(BARS[1], dataList[-1]+0.05, f"{(dataList[-1]*100):.1f}%")
    plt.xlim(BAR_LOWER_BOUND,BAR_UPPER_BOUND)
    plt.ylim(0,1)
    plt.xticks(BARS, ["Switch", "Stay"])
    plt.ylabel('Winning rate')
    plt.title('Winning rate for different choices')

def pieChart(dataList):
    for i in range(6,9):
        plt.figure()
        plt.title(indexMap()[i])
        labels = ["Win", "Loss"]
        plt.pie([dataList[i], 1-dataList[i]], labels=labels, autopct='%1.1f%%')

def main():
    dataList = readFile()
    barChart(dataList)
    pieChart(dataList)
    plt.show()

main()