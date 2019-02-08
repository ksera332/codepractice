import random

RANK,SURT = 0,1
def get_point(hand):
    result = 0
    ace_flag = False
    for card in hand:
        num = card[RANK]
        if num == 1:#Aならフラグ立つ
            ace_flag = True
        if num > 10:
            num = 10
        result += num
    if ace_flag and result <= 11:#Aかつ11以下なら＋10
        result += 10
    return result#手札の合計#手札の合計値を表示

def print_player_hand(player_hand):
    print("プレイヤー (",get_point(player_hand),  "):    ")
    for card in player_hand:
        print("[",card[SURT],card[RANK],"]")
        print()#プレイヤーの手札表示#プレイヤーの手札を表示

def print_dealer_hand(dealer_hand,uncovered):
    if uncovered :
        print("ディーラー (",get_point(dealer_hand), "): ")
    else:
        print("ディーラー ( ?? ):    ")
    flag = True
    for card in dealer_hand:
        if flag or uncovered:
            print("[" , card[SURT],card[RANK], "]")
            flag = False
        else:
            print("[ * * ]")
    print()#ディーラーの手札表示#ディーラーの手札を表示#第2引数は2枚目の手札を公開するかどうか

def make_dack():
    suits = ["S","H","D","C"]#マークの定義
    ranks = range(1,14)#数字の定義
    deck = [(x,y) for x in ranks for y in suits]
    random.shuffle(deck)#デッキをシャッフル
    return deck#デッキ作成#トランプのデッキ作成（ジョーカーなし）

def player_op(deck,player_hand,op):#プレイヤーの行動
    doubled,ending = False,False
    if op == "1":
        print("[ プレイヤー：スタンド ]")
        doubled,ending = False,True

    elif op == "2":
        print("[ プレイヤー:ヒット ]")
        player_hand.append(deck.pop())
        print_player_hand(player_hand)
        doubled,ending = False,False

    elif op == "3":
        if len(player_hand) == 2:
            print("[ プレイヤー：ダブル ]")
            player_hand.append(deck.pop())
            print_player_hand(player_hand)
            doubled,ending = True,True
        else:
            print("ダブルはできません")

    if get_point(player_hand) > 21 :
        print("[ プレイヤーはバストした! ]")
        ending = True
    elif get_point(player_hand) == 21:
        print("21です!")
        ending = True

    return doubled,ending

def dealer_op(deck,player_hand,dealer_hand):#ディーラーターン
    while get_point(player_hand) <= 21:
        if get_point(dealer_hand) >= 17:
            print("[ ディーラー　：　スタンド　]")
            break
        else:
            print("[ ディーラー　：　ヒット　]")
            dealer_hand.append(deck.pop())
    print_dealer_hand(dealer_hand,False)

def win_lose(dealer_hand,player_hand,bet,player_money):#勝敗判定処理
    player_point = get_point(player_hand)
    dealer_point = get_point(dealer_hand)
    if player_point <= 21:#プレイヤーの手札が21を超えていないか
        if (player_point > dealer_point) or (dealer_point > 21):#プレイヤー勝利
            if player_point == 21:
                return ("プレイヤーの勝ち",player_money + int(bet*2.5))
            else:
                return ("プレイヤーの勝ち",player_money + int(bet*2))
        elif player_point == dealer_point:#引き分け
            return ("引き分け",player_money + bet)
        else:#負け
            return ("プレイヤーの負け",player_money)
    else:#プレイヤーの自爆
        return ("プレイヤーの負け",player_money)

def main():
    turn = 1
    player_money = 100
    while(player_money > 0):
        print("-"*20)
        print("ターン:",turn)
        print("所持金:",player_money)
        print("-"*20)
        player_hand = []#プレイヤーの手札のリスト
        dealer_hand = []#ディーラーの手札のリスト
        deck = make_dack()#デッキ作成

        try:
            bet = int(input("ベット額　> "))
        except:
            print("整数を入力してください")
            continue

        if bet > player_money:
            print("所持金が不足しています")
            continue

        elif bet <= 0 :
            print("ベットできるのは1以上です")
            continue

        player_money -= bet

        if len(deck) < 10:
            deck = make_dack

        for i in range(2):#プレイヤーとディーラーが2枚引く
            player_hand.append(deck.pop())
            dealer_hand.append(deck.pop())

        print("-"*20)
        print_player_hand(player_hand)
        print_dealer_hand(dealer_hand,False)
        print("-"*20)

        while True:#プレイヤーターン
            op = input("スタンド ： 1, ヒット : 2, ダブル : 3 > ")
            doubled,ending = player_op(deck,player_hand,op)
            if doubled:#ダブルした時の処理
                player_money -= bet
                bet += bet
            if ending:
                break

        dealer_op(deck,player_hand,dealer_hand)#ディーラーターン

        print("-"*20)
        print_player_hand(player_hand)
        print_dealer_hand(dealer_hand,True)
        print("-"*20)
        #勝敗処理
        message,player_money = win_lose(dealer_hand,player_hand,bet,player_money)
        print(message)

        turn += 1
        input("次のターンへ")
    print("ゲームオーバー")

if __name__ == "__main__":
    main()
