VERSION 5.00
Begin VB.Form Form1 
   BackColor       =   &H8000000D&
   Caption         =   "Form1"
   ClientHeight    =   5580
   ClientLeft      =   120
   ClientTop       =   465
   ClientWidth     =   7140
   LinkTopic       =   "Form1"
   MousePointer    =   1  'Arrow
   ScaleHeight     =   5580
   ScaleWidth      =   7140
   StartUpPosition =   2  'CenterScreen
   Begin VB.CommandButton Command11 
      Caption         =   "X^Y"
      Height          =   735
      Left            =   5520
      TabIndex        =   16
      Top             =   360
      Width           =   1455
   End
   Begin VB.CommandButton Command10 
      Caption         =   "vX"
      Height          =   735
      Left            =   5520
      TabIndex        =   15
      Top             =   1440
      Width           =   1455
   End
   Begin VB.CommandButton Command9 
      Caption         =   "MOD(X%Y)"
      Height          =   735
      Left            =   5520
      TabIndex        =   14
      Top             =   2520
      Width           =   1455
   End
   Begin VB.CommandButton Command8 
      Caption         =   "TAN(X)"
      Height          =   615
      Left            =   5520
      TabIndex        =   13
      Top             =   4680
      Width           =   1455
   End
   Begin VB.CommandButton Command7 
      Caption         =   "COS(X)"
      Height          =   615
      Left            =   3840
      TabIndex        =   12
      Top             =   4680
      Width           =   1335
   End
   Begin VB.CommandButton Command6 
      Caption         =   "SIN(X)"
      Height          =   615
      Left            =   2040
      TabIndex        =   11
      Top             =   4680
      Width           =   1455
   End
   Begin VB.CommandButton Command5 
      Caption         =   "LOG(X)"
      Height          =   615
      Left            =   240
      TabIndex        =   10
      Top             =   4680
      Width           =   1455
   End
   Begin VB.CommandButton Command4 
      Caption         =   "Division(X/Y)"
      Height          =   615
      Left            =   5520
      TabIndex        =   9
      Top             =   3720
      Width           =   1455
   End
   Begin VB.CommandButton Command3 
      Caption         =   "Multiplication(X*Y)"
      Height          =   615
      Left            =   3720
      TabIndex        =   8
      Top             =   3720
      Width           =   1575
   End
   Begin VB.CommandButton Command2 
      Caption         =   "Subtraction(X-Y)"
      Height          =   615
      Left            =   2040
      TabIndex        =   7
      Top             =   3720
      Width           =   1455
   End
   Begin VB.CommandButton Command1 
      Caption         =   "Addition(X+Y)"
      Height          =   615
      Left            =   240
      TabIndex        =   6
      Top             =   3720
      Width           =   1455
   End
   Begin VB.TextBox Text3 
      Height          =   855
      Left            =   1920
      TabIndex        =   4
      Top             =   2400
      Width           =   2535
   End
   Begin VB.TextBox Text2 
      Height          =   855
      Left            =   1920
      TabIndex        =   1
      Top             =   1200
      Width           =   2535
   End
   Begin VB.TextBox Text1 
      Height          =   735
      Left            =   1920
      TabIndex        =   0
      Top             =   240
      Width           =   2535
   End
   Begin VB.Label Label3 
      Caption         =   "Result"
      Height          =   615
      Left            =   360
      TabIndex        =   5
      Top             =   2520
      Width           =   1455
   End
   Begin VB.Label Label2 
      Caption         =   "Number 2"
      Height          =   615
      Left            =   360
      TabIndex        =   3
      Top             =   1320
      Width           =   1335
   End
   Begin VB.Label Label1 
      Caption         =   "Number 1"
      Height          =   495
      Left            =   360
      TabIndex        =   2
      Top             =   360
      Width           =   1335
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Declare Function add1 Lib "D:\dll1\Debug\dll1.dll" (ByVal x As Double, ByVal y As Double) As Double
Private Declare Function sub1 Lib "D:\dll1\Debug\dll1.dll" (ByVal x As Double, ByVal y As Double) As Double
Private Declare Function mul1 Lib "D:\dll1\Debug\dll1.dll" (ByVal x As Double, ByVal y As Double) As Double
Private Declare Function div1 Lib "D:\dll1\Debug\dll1.dll" (ByVal x As Double, ByVal y As Double) As Double
Private Declare Function modxy Lib "D:\dll1\Debug\dll1.dll" (ByVal x As Double, ByVal y As Double) As Double
Private Declare Function xty Lib "D:\dll1\Debug\dll1.dll" (ByVal x As Double, ByVal y As Double) As Double
Private Declare Function xsqrt Lib "D:\dll1\Debug\dll1.dll" (ByVal x As Double) As Double
Private Sub Command1_Click()
Text3.Text = add1(Val(Text1.Text), Val(Text2.Text))

End Sub

Private Sub Command10_Click()
Text3.Text = xsqrt(Val(Text1.Text))
End Sub

Private Sub Command11_Click()
Text3.Text = xty(Val(Text1.Text), Val(Text2.Text))
End Sub

Private Sub Command2_Click()
Text3.Text = sub1(Val(Text1.Text), Val(Text2.Text))
End Sub

Private Sub Command3_Click()
Text3.Text = mul1(Val(Text1.Text), Val(Text2.Text))
End Sub

Private Sub Command4_Click()
Text3.Text = div1(Val(Text1.Text), Val(Text2.Text))
End Sub

Private Sub Command5_Click()
Text3.Text = Log(Val(Text1.Text))
End Sub

Private Sub Command6_Click()
Text3.Text = Sin(Val(Text1.Text))
End Sub

Private Sub Command7_Click()
Text3.Text = Cos(Val(Text1.Text))
End Sub

Private Sub Command8_Click()
Text3.Text = Tan(Val(Text1.Text))
End Sub

Private Sub Command9_Click()
Text3.Text = modxy(Val(Text1.Text), Val(Text2.Text))
End Sub

