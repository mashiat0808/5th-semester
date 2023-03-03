import numpy as np
import pandas as pd
import pprint


def read_csv(file_path):
    df = pd.read_csv(file_path)
    return df


def find_target_value_entropy(data):
    target_column = data.keys()[-1]
    target_values = data[target_column].unique()
    entropy = 0

    for value in target_values:
        probability = data[target_column].value_counts()[value] / data.shape[0]
        entropy -= probability * np.log2(probability)

    return np.float16(entropy)



def find_attribute_entropy(data, attribute):
    target_column = data.keys()[-1]
    target_values = data[target_column].unique()
    attribute_values = data[attribute].unique()
    average_entropy = 0

    for itemA in attribute_values:
        entropy = 0
        for itemT in target_values:
            numerator = len( data[attribute][data[attribute] == itemA][data[target_column] == itemT] )
            denominator = len( data[attribute][data[attribute] == itemA] )

            if denominator != 0 and numerator != 0:
                probability = numerator/denominator
                entropy -= probability * np.log2(probability)
            else:
                entropy += 0

        average_entropy += ( denominator/ len(data) ) * entropy

    return np.float16(average_entropy)


def find_node(data):
    # print(data)

    arr = []
    parent_entropy = find_target_value_entropy(data)

    for key in data.keys()[ : -1]:
        arr.append( parent_entropy - find_attribute_entropy(data, key) )

    return data.keys()[np.argmax(arr)]


def create_new_table(data, attribute, value):
    return data[data[attribute] == value].reset_index(drop = True)


def buildTree(data, tree = None):
    parent_node = find_node(data)
    parent_node_attributes = data[parent_node].unique()
    target_column = data.keys()[-1]
    # print(parent_node, parent_node_attributes)

    if tree is None:
        tree = {}
        tree[parent_node] = {}

    for item in parent_node_attributes:
        new_table = create_new_table(data, parent_node, item)

        # target_value_unique_count, target_values =
        target_values = np.unique(new_table[target_column])

        if len(target_values) == 1:
            tree[parent_node][item] = target_values
        else:
            tree[parent_node][item] = buildTree(new_table)

    return tree



def nodeEdges(tree, case):
    for node, edges in tree.items():
        if case.get(node) is not None:
            return node, edges

def getResult(tree, case):

    got = True
    noDecision = ["No_decision_Taken"]
    while( isinstance(tree, dict)):
        got = False

        node, tree = nodeEdges(tree, case)

        for item, value in tree.items():
            if case[node] == item:
                tree = value
                got = True
                break
        if got != True:
            break


    if got == False:
        return noDecision
    else:
        return tree






dataframe = read_csv("car.data")

trainingData = dataframe.sample(frac = 0.8)
testingData = dataframe.drop(trainingData.index)

trainingData.reset_index(inplace = True, drop = True)
testingData.reset_index(inplace = True, drop = True)

Tree = buildTree(trainingData)

print(testingData)

print("\n\n\n")
pprint.pprint(Tree)


loop = 0
TruePrediction = 0
while loop != len(testingData):

    testCase = testingData.iloc[loop].to_dict()


    result = getResult(Tree, testCase)

    targetKey, targetVal = testCase.popitem()

    for item in result:
        predictedVal= item

    if targetVal == predictedVal:
        TruePrediction+=1

    loop+=1


print('\n\n\nAccuracy: ', (TruePrediction/len(testingData))*100, "%" )