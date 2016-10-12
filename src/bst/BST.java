/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

/**
 *
 * @author tomas
 */
public class BST {

    //private Kniha k = new Kniha(5);
    private BST_node root;// = new BST_node(k);

    public void add(BST_node paNode) {

        if (root == null) {
            root = paNode;
        }

        BST_node actual = root;
        while (true) {

            System.out.println("Adept" + paNode.getData().toString());
            if (actual.getData().compare(paNode) == -1) {
                if (actual.getLeft() == null) {
                    actual.setLeft(paNode);
                    System.out.println(paNode.getData().toString() + "ulozene do lava");
                    break;
                } else {
                    actual = actual.getLeft();
                    System.out.println(paNode.getData().toString() + "pokracuje  do lava");
                }

            } else if (actual.getData().compare(paNode) == 1) {
                if (actual.getRight() == null) {
                    actual.setRight(paNode);
                    System.out.println(paNode.getData().toString() + "ulozene do prava");
                    break;
                } else {
                    actual = actual.getRight();
                    System.out.println(paNode.getData().toString() + "pokracuje do prava");
                }
            } else {
                System.out.println("Duplikat");
                break;
            }
        }
    }

    public void delete(Object paKey) {
        BST_node actual = root;
        BST_node rodic = null;

        //BST_node hladany=(BST_node)this.search(paKey);
        while (true) {

            if (actual.getData().compare(paKey) == 0) {
                if (actual.getPocetDeti() == 0) {
                    if (rodic.getLeft() == actual) {
                        rodic.setLeft(null);
                        break;
                    } else {
                        rodic.setRight(null);
                        break;
                    }
                } else if (actual.getPocetDeti() == 1) {
                    if (rodic.getLeft() == actual) {
                        if (actual.getLeft() == null) {
                            rodic.setLeft(actual.getRight());
                            break;
                        } else {
                            rodic.setLeft(actual.getLeft());
                            break;
                        }
                    } else if (actual.getLeft() == null) {
                        rodic.setRight(actual.getRight());
                        break;
                    } else {
                        rodic.setRight(actual.getLeft());
                        break;
                    }
                } else {
                    BST_node min = actual.getRight();
                    BST_node rodicMin = null;
                    //Najdenie minima v pravom podstrome
                    while (min.getLeft() != null) {
                        rodicMin = min;
                        min = min.getLeft();

                    }

                    //System.out.println("min"+min.toString());
                    //break;
                    
                    if(actual==root){
                        System.out.println("CHES mazat koren");
                     min.setLeft(root.getLeft());
                     min.setRight(root.getRight());
                     root=min;
                     
                     
                     break;
                    }
                    else{     
                    
                    min.setLeft(actual.getLeft());
                    min.setRight(actual.getRight());
                    rodicMin.setLeft(null);

                    if (actual != root) {
                        if (rodic.getLeft() == actual) {
                            rodic.setLeft(min);
                        } else {
                            rodic.setRight(min);
                        }
                    }    
                    }

                    break;
                }

            } else if (actual.getData().compare(paKey) == -1) {
                rodic = actual;
                actual = actual.getLeft();
            } else {
                rodic = actual;
                actual = actual.getRight();
            }
        }
    }

    public BST_node search(Object paKey) {

        BST_node actual = root;
        /*if(actual.getData().getKey().equals(paKey)){              
            return (BST_node)actual;
        }*/
        while (true) {
            if (actual.getData().compare(paKey) == 0) {
                return (BST_node) actual;
            }

            if (actual.getData().compare(paKey) == -1) {
                actual = actual.getLeft();
            } else if (actual.getData().compare(paKey) == 1) {
                actual = actual.getRight();
            }

            if (actual == null) {
                System.out.println("nenasiel sa");
                return null;
            }
        }

    }

    /**
     * Preorder
     *
     * @param koren
     */
    private void vypisStrom(BST_node koren) {
        if (koren == null) {
            return;
        }
        // vypisStrom(koren.getLeft());
        System.out.println(koren.getData().toString());
        vypisStrom(koren.getLeft());
        vypisStrom(koren.getRight());
    }

    public void vypis() {
        vypisStrom(root);
    }

    public BST_node getRoot() {
        return root;
    }

}
