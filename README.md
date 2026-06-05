# SkyMMO_Core

SkyMMO_Coreは、Minecraftサーバー向けのMMO要素や高度なカスタムアイテム、属性（Attributes）システムを構築・拡張するためのコアフレームワークプラグインです。
開発者が独自のアイテム、スキル、ステータス、レア度などをモジュール単位で直感的に実装・管理できるAPIおよびデータ構造を提供します。

---

## 🚀 主な機能・特徴

* **拡張可能なカスタムアイテムAPI (`api/item`)**
    * 武器（Weapons）、防具（Armor）、素材（Material）といった様々なアイテムタイプを統合管理。
    * アイテムごとの使用条件（Requirement）や、付与するスキル（ItemSkill）の仕組みを標準装備。
* **高度なモジュール式データプロセッサ (`api/module`)**
    * アイテムの生成、読み込み（Reader）、更新（Updater）、計算（Calculator）のライフサイクルをコンテキスト（Context）経由で分離。
    * 名前、レア度、基礎ステータス、属性などをそれぞれ独立したモジュールとして実装可能。
* **永続データ管理 (PDC)**
    * Minecraftの `PersistentDataContainer` (PDC) をラップした安全なデータ管理クラス (`PDCWrapper`) を内蔵。
* **柔軟なレジストリシステム (`registry`)**
    * カスタムアイテムやカスタム属性を動的に登録・一元管理。

---

## 📁 プロジェクト構造 (Package Structure)

JARファイルおよびリポジトリから解析された主要なパッケージ構成は以下の通りです：

```text
com.github.mry114.skymmo_core
├── SkyMMO_Core.class             # プラグインのメインクラス
├── api/                          # 開発者向けの拡張用APIインターフェース群
│   ├── attribute/                # 属性API (IAttribute)
│   ├── item/                     # カスタムアイテム・装備品API (ICustomItem, IEquipmentItem)
│   ├── module/                   # コンテキスト・計算用プロセッサモジュール
│   └── type/                     # グループ・タイプ定義
├── core/                         # APIのコア実装
│   ├── context/                  # コンテキストの実装 (ItemContext, ItemGeneratorContext 等)
│   └── item/                     # 各種アイテムタイプの実装 (WeaponItem, ArmorItem 等)
├── data/                         # プラグイン内部の標準データ・ロジック・サンプル
│   ├── context/                  # 各種モジュールロジック (Name, Rarity, Skill, BaseStatus)
│   ├── model/                    # 実装の参考となるサンプルコード (ExampleWeapon, ExampleArmor 等)
│   └── type/                     # Enum類 (Rarity, Status, ArmorType, WeaponType 等)
├── listener/                     # サーバーイベントハンドリング (EventListener)
├── registry/                     # レジストリ (ItemRegistry, ItemAttributeRegistry)
└── util/                         # ユーティリティクラス群 (MetaDataUtil, PDCWrapper, DisplayStatusUtil)